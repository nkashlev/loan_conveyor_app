package ru.nkashlev.loan_conveyor_app.conveyor.utils;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;
import ru.nkashlev.loan_conveyor_app.conveyor.model.LoanApplicationRequestDTO;

import java.math.BigDecimal;
import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertTrue;

@ExtendWith(MockitoExtension.class)
class ValidateLoanApplicationRequestUtilTest {
    @InjectMocks
    private ValidateLoanApplicationRequestUtil validateLoanApplicationRequestUtil;

    @Test
    void validateRequest() {
        LoanApplicationRequestDTO request = new LoanApplicationRequestDTO();
        request.setAmount(new BigDecimal("400000"));
        request.setTerm(12L);
        request.setFirstName("John");
        request.setLastName("Doe");
        request.setEmail("johndoe@example.com");
        request.setBirthdate(LocalDate.of(2000, 1, 1));
        request.setPassportSeries("1234");
        request.setPassportNumber("567890");
        boolean isValid = validateLoanApplicationRequestUtil.validateRequest(request);
        assertTrue(isValid);
    }
}