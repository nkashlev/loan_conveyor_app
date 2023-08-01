package ru.nkashlev.loan_conveyor_app.conveyor.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import ru.nkashlev.loan_conveyor_app.conveyor.dto.LoanApplicationRequestDTO;
import ru.nkashlev.loan_conveyor_app.conveyor.dto.LoanOfferDTO;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

import static org.mockito.Mockito.when;
@ExtendWith(MockitoExtension.class)
class LoanServiceTest {

    @Mock
    private LoanApplicationRequestDTO loanApplicationRequest;

    @InjectMocks
    private LoanService loanService;

    @BeforeEach
    void setUp() throws Exception {
        when(loanApplicationRequest.getAmount()).thenReturn(BigDecimal.valueOf(20000));
        when(loanApplicationRequest.getTerm()).thenReturn(12);
        when(loanApplicationRequest.getFirstName()).thenReturn("John");
        when(loanApplicationRequest.getLastName()).thenReturn("Doe");
        when(loanApplicationRequest.getEmail()).thenReturn("john.doe@example.com");
        when(loanApplicationRequest.getBirthdate()).thenReturn(LocalDate.of(1990, 1, 1));
        when(loanApplicationRequest.getPassportSeries()).thenReturn("1234");
        when(loanApplicationRequest.getPassportNumber()).thenReturn("567890");
    }

    @Test
    void testGetLoanOffers() {
        List<LoanOfferDTO> loanOffers = loanService.getLoanOffers(loanApplicationRequest);
        Assertions.assertEquals(4, loanOffers.size());
    }

    @Test
    void testValidateRequest() {
        boolean isValid = loanService.validateRequest(loanApplicationRequest);
        Assertions.assertTrue(isValid);
    }

    @Test
    void testMonthlyPayment() {
        double rate = 10.0;
        int term = 12;
        double amount = 20000.0;
        BigDecimal monthlyPayment = LoanService.monthlyPayment(rate, term, amount);
        Assertions.assertEquals(BigDecimal.valueOf(1758.318), monthlyPayment);
    }
}