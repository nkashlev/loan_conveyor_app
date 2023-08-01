package ru.nkashlev.loan_conveyor_app.conveyor.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import ru.nkashlev.loan_conveyor_app.conveyor.dto.CreditDTO;
import ru.nkashlev.loan_conveyor_app.conveyor.dto.Enum.EmploymentStatus;
import ru.nkashlev.loan_conveyor_app.conveyor.dto.Enum.Gender;
import ru.nkashlev.loan_conveyor_app.conveyor.dto.Enum.MaritalStatus;
import ru.nkashlev.loan_conveyor_app.conveyor.dto.Enum.Position;
import ru.nkashlev.loan_conveyor_app.conveyor.dto.PaymentScheduleElement;
import ru.nkashlev.loan_conveyor_app.conveyor.dto.ScoringDataDTO;
import ru.nkashlev.loan_conveyor_app.conveyor.exceptions.ScoringException;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDate;
import java.time.Month;
import java.time.Period;
import java.util.ArrayList;
import java.util.List;

import static ru.nkashlev.loan_conveyor_app.conveyor.service.LoanService.monthlyPayment;

@Service
public class ScoringService {

    private static final Logger LOGGER = LoggerFactory.getLogger(ScoringService.class);

    public CreditDTO calculate(ScoringDataDTO request) {
        CreditDTO creditDTO = new CreditDTO();
        ScoringService scoringService = new ScoringService();
        double calculateRate = scoringService.getBaseRate(request);
        BigDecimal monthlyPayment = monthlyPayment(calculateRate, request.getTerm(), request.getAmount().doubleValue());
        creditDTO.setRate(BigDecimal.valueOf(calculateRate));
        creditDTO.setMonthlyPayment(monthlyPayment);
        creditDTO.setPaymentSchedule(scoringService.calculatePaymentSchedule(request.getAmount(), BigDecimal.valueOf(calculateRate), request.getTerm()));
        creditDTO.setPsk(scoringService.getPSK(monthlyPayment.doubleValue(), request.getTerm()));
        LOGGER.info("Credit calculated successfully");
        return creditDTO;
    }

    protected double getBaseRate(ScoringDataDTO request) {
        double rate = 10.0;
        // правило 1: рабочий статус
        if (request.getEmployment().getEmploymentStatus() == EmploymentStatus.UNEMPLOYED) {
            LOGGER.error("Cannot calculate interest rate for unemployed customers");
            throw new ScoringException("Cannot calculate interest rate for unemployed customers");
        } else if (request.getEmployment().getEmploymentStatus() == EmploymentStatus.SELF_EMPLOYED) {
            rate += 1;
        } else if (request.getEmployment().getEmploymentStatus() == EmploymentStatus.BUSINESS_OWNER) {
            rate += 3;
        } else if (request.getEmployment().getEmploymentStatus() == EmploymentStatus.EMPLOYED) {
            rate += 0;
        }

        // правило 2: позиция на работе
        if (request.getEmployment().getPosition() == Position.MANAGER) {
            rate -= 2;
        } else if (request.getEmployment().getPosition() == Position.TOP_MANAGER) {
            rate -= 4;
        } else if (request.getEmployment().getPosition() == Position.ENGINEER) {
            rate -= 3;
        } else if (request.getEmployment().getPosition() == Position.OTHER) {
            rate -= 0;
        }

        // правило 3: сумма займа
        BigDecimal monthlyIncome = request.getEmployment().getSalary();
        BigDecimal loanAmount = request.getAmount();
        if (loanAmount.compareTo(monthlyIncome.multiply(new BigDecimal("20"))) > 0) {
            LOGGER.error("Loan amount exceeds 20 times the monthly income");
            throw new ScoringException("Loan amount exceeds 20 times the monthly income");
        }

        // правило 4: семейное положение
        if (request.getMaritalStatus() == MaritalStatus.MARRIED) {
            rate -= 3;
        } else if (request.getMaritalStatus() == MaritalStatus.DIVORCED) {
            rate += 1;
        } else if (request.getMaritalStatus() == MaritalStatus.SINGLE) {
            rate += 1;
        } else if (request.getMaritalStatus() == MaritalStatus.WIDOWED) {
            rate += 1;
        }

        // правило 5: количество иждивенцев
        if (request.getDependentAmount() > 1) {
            rate += 1;
        }

        // правило 6: возраст
        int age = Period.between(request.getBirthdate(), LocalDate.now()).getYears();
        if (age < 20 || age > 60) {
            LOGGER.error("Customer age is not within the acceptable range");
            throw new ScoringException("Customer age is not within the acceptable range");
        }

        // правило 7: пол
        if (request.getGender() == Gender.FEMALE && age >= 35 && age <= 60) {
            rate -= 3;
        } else if (request.getGender() == Gender.MALE && age >= 30 && age <= 55) {
            rate -= 3;
        } else if (request.getGender() == Gender.NON_BINARY) {
            rate += 3;
        }

        // правило 8: стаж работы
        int monthsOfExperience = request.getEmployment().getWorkExperienceCurrent();
        int monthsOfTotalExperience = request.getEmployment().getWorkExperienceTotal();
        if (monthsOfTotalExperience < 12 || monthsOfExperience < 3) {
            LOGGER.error("Work experience is not sufficient");
            throw new ScoringException("Work experience is not sufficient");
        }
        return rate;
    }

    protected List<PaymentScheduleElement> calculatePaymentSchedule(BigDecimal loanAmount, BigDecimal rate, int term) {
        List<PaymentScheduleElement> paymentSchedule = new ArrayList<>();
        BigDecimal remainingAmount = loanAmount;
        BigDecimal monthlyRate = rate.divide(BigDecimal.valueOf(12), 10, RoundingMode.HALF_UP).divide(BigDecimal.valueOf(100));
        BigDecimal annuityPayment = loanAmount.multiply(monthlyRate)
                .divide(BigDecimal.ONE.subtract(BigDecimal.ONE.divide(BigDecimal.ONE.add(monthlyRate).pow(term), 10, RoundingMode.HALF_UP)), 2, RoundingMode.HALF_UP);

        LocalDate currentDate = LocalDate.now();
        for (int i = 1; i <= term; i++) {
            BigDecimal interestAmount = remainingAmount.multiply(monthlyRate).setScale(2, RoundingMode.HALF_UP); //  сумма процентов (interestAmount)
            BigDecimal principalAmount = annuityPayment.subtract(interestAmount).setScale(2, RoundingMode.HALF_UP); // сумма основного долга (principalAmount)
            remainingAmount = remainingAmount.subtract(principalAmount).setScale(2, RoundingMode.HALF_UP); //остаток кредита (remainingAmount)

            LocalDate nextMonth = currentDate.plusMonths(i + 1);
            if (nextMonth.isAfter(LocalDate.of(2023, Month.JANUARY, 31))) {
                nextMonth.plusYears(1);
            }

            paymentSchedule.add(new PaymentScheduleElement(i, nextMonth, loanAmount, interestAmount, principalAmount, remainingAmount));
        }
        LOGGER.info("Payment schedule calculated successfully");
        return paymentSchedule;
    }

    protected BigDecimal getPSK(double monthlyPayment, int term) {
        LOGGER.info("PSK calculated successfully");
        return BigDecimal.valueOf(monthlyPayment * term);
    }
}

