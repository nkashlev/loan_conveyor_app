package ru.nkashlev.loan_conveyor_app.conveyor.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import ru.nkashlev.loan_conveyor_app.conveyor.dto.LoanApplicationRequestDTO;
import ru.nkashlev.loan_conveyor_app.conveyor.dto.LoanOfferDTO;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

@Service
public class LoanService {
    private static long id = 0;
    @Value("${baseRate}")
    private double baseRate;
    private static final Logger LOGGER = LoggerFactory.getLogger(LoanService.class);

    public List<LoanOfferDTO> getLoanOffers(LoanApplicationRequestDTO loanApplicationRequest) {
        LOGGER.info("Starting to generate loan offers for loan application");
        List<LoanOfferDTO> loanOffers = new ArrayList<>();
        boolean[] insuranceValues = {false, true};
        boolean[] salaryClientValues = {false, true};

        for (boolean insurance : insuranceValues) {
            for (boolean salaryClient : salaryClientValues) {
                // Вычисляем ставку на основании выбранных параметров
                double rate = baseRate;
                if (insurance) {
                    // Уменьшаем ставку на 3 при наличии страховки
                    rate -= 3.0;
                }
                if (salaryClient) {
                    // Уменьшаем ставку на 1 при наличии зарплатного клиента
                    rate -= 1.0;
                }
                // Формируем кредитное предложение
                LoanOfferDTO offer = new LoanOfferDTO();
                offer.setApplicationId(++id);
                offer.setRequestedAmount(loanApplicationRequest.getAmount());
                offer.setTotalAmount(loanApplicationRequest.getAmount().add(BigDecimal.valueOf(insurance ? 100000 : 0)));
                offer.setTerm(loanApplicationRequest.getTerm());
                offer.setMonthlyPayment(monthlyPayment(rate, loanApplicationRequest.getTerm(), loanApplicationRequest.getAmount().doubleValue()));
                offer.setRate(BigDecimal.valueOf(rate));
                offer.setIsInsuranceEnabled(insurance);
                offer.setIsSalaryClient(salaryClient);
                loanOffers.add(offer);
            }
        }
        Comparator<LoanOfferDTO> rateComparator = (o1, o2) -> Double.compare(o2.getRate().doubleValue(), o1.getRate().doubleValue());
        loanOffers.sort(rateComparator);
        LOGGER.info("Generated loan offers");
        return loanOffers;
    }

    public boolean validateRequest(LoanApplicationRequestDTO request) {
        boolean isAmountValid = request.getAmount().intValue() >= 10000;
        boolean isTermValid = request.getTerm() >= 6;
        boolean isFirstNameValid = request.getFirstName().matches("[A-Za-z]{2,30}");
        boolean isLastNameValid = request.getLastName().matches("[A-Za-z]{2,30}");
        boolean isMiddleNameValid = true; // Отчество не обязательно

        if (request.getMiddleName() != null) {
            isMiddleNameValid = request.getMiddleName().matches("[A-Za-z]{2,30}");
        }
        boolean isEmailValid = request.getEmail().matches("[\\w.]{2,50}@[\\w.]{2,20}");
        boolean isBirthdateValid = request.getBirthdate().isBefore(LocalDate.now().minusYears(18));
        boolean isPassportSeriesValid = request.getPassportSeries().matches("\\d{4}");
        boolean isPassportNumberValid = request.getPassportNumber().matches("\\d{6}");

        boolean isValid = isAmountValid && isTermValid && isFirstNameValid && isLastNameValid && isMiddleNameValid && isEmailValid
                && isBirthdateValid && isPassportSeriesValid && isPassportNumberValid;

        if (!isValid) {
            LOGGER.error("Invalid loan application request: {}", request);
        }
        return isValid;
    }

    public static BigDecimal monthlyPayment(double rate, int term, double amount) {
        LOGGER.info("Calculating monthly payment");
        double monthlyRate = (rate / 12) / 100;
        double n = Math.pow((1 + monthlyRate), term);
       // double result = amount * (monthlyRate * n) / (n - 1);

        BigDecimal bigDecimal = BigDecimal.valueOf(amount * (monthlyRate * n) / (n - 1));
        LOGGER.info("Monthly payment calculated");
        return bigDecimal.setScale(3, RoundingMode.CEILING);
       // return result;

    }
}