package ru.nkashlev.loan_conveyor_app.conveyor.dto;

import lombok.Data;

import java.math.BigDecimal;
import java.util.List;
// данные о кредите. Объект данных о кредите, содержащий идентификатор заявки, сумму, процентную ставку и срок.
@Data
public class CreditDTO {

    private BigDecimal amount;
    private Integer term;
    private BigDecimal monthlyPayment;
    private BigDecimal rate;
    private BigDecimal psk;
    private Boolean isInsuranceEnabled;
    private Boolean isSalaryClient;
    private List<PaymentScheduleElement> paymentSchedule;

}
