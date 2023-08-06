package ru.nkashlev.loan_conveyor_app.conveyor.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import ru.nkashlev.loan_conveyor_app.conveyor.model.LoanApplicationRequestDTO;

import java.time.LocalDate;

@Component
public class ValidateLoanApplicationRequestUtil {

    private static final Logger LOGGER = LoggerFactory.getLogger(ValidateLoanApplicationRequestUtil.class);
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
}
