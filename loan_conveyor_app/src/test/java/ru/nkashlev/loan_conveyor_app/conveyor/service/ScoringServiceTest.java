package ru.nkashlev.loan_conveyor_app.conveyor.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import ru.nkashlev.loan_conveyor_app.conveyor.dto.CreditDTO;
import ru.nkashlev.loan_conveyor_app.conveyor.dto.EmploymentDTO;
import ru.nkashlev.loan_conveyor_app.conveyor.dto.Enum.EmploymentStatus;
import ru.nkashlev.loan_conveyor_app.conveyor.dto.Enum.MaritalStatus;
import ru.nkashlev.loan_conveyor_app.conveyor.dto.Enum.Position;
import ru.nkashlev.loan_conveyor_app.conveyor.dto.PaymentScheduleElement;
import ru.nkashlev.loan_conveyor_app.conveyor.dto.ScoringDataDTO;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class ScoringServiceTest {

    @Mock
    private ScoringService scoringService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        scoringService = new ScoringService();
    }


    @Test
    public void testCalculate() {
        ScoringService scoringServiceMock = Mockito.mock(ScoringService.class);
        Logger loggerMock = Mockito.mock(Logger.class);

        ScoringDataDTO request = new ScoringDataDTO();
        request.setAmount(BigDecimal.valueOf(10000));
        request.setTerm(12);
        request.setEmployment(new EmploymentDTO(EmploymentStatus.EMPLOYED, "1234353", BigDecimal.valueOf(50000), Position.MANAGER,24, 12));
        request.setMaritalStatus(MaritalStatus.MARRIED);
        request.setDependentAmount(1);
        request.setBirthdate(LocalDate.of(1996, 10, 21));

        double baseRate = 10.0;
        List<PaymentScheduleElement> paymentSchedule = new ArrayList<>();
        double psk = 1.0;

        Mockito.when(scoringServiceMock.getBaseRate(request)).thenReturn(baseRate);
        Mockito.when(scoringServiceMock.calculatePaymentSchedule(request.getAmount(), BigDecimal.valueOf(baseRate), request.getTerm())).thenReturn(paymentSchedule);
        Mockito.when(scoringServiceMock.getPSK(Mockito.anyDouble(), Mockito.anyInt())).thenReturn(BigDecimal.valueOf(psk));

        CreditDTO result = new ScoringService().calculate(request);

        assertEquals(BigDecimal.valueOf(baseRate), result.getRate());
        assertNotNull(result.getMonthlyPayment());
        assertEquals(paymentSchedule, result.getPaymentSchedule());
        Mockito.verify(loggerMock).info("Credit calculated successfully");
    }
}