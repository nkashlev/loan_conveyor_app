package ru.nkashlev.loan_conveyor_app.conveyor.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDate;

@Data
@Schema(description = "График платежей")
public class PaymentScheduleElement {
    @Schema(description = "Номер платежа")
    private Integer number;

    @Schema(description = "Дата платежа")
    private LocalDate date;

    @Schema(description = "Общая сумма платежа")
    private BigDecimal totalPayment;

    @Schema(description = "Сумма процентов в платеже")
    private BigDecimal interestPayment;

    @Schema(description = "Сумма погашения долга в платеже")
    private BigDecimal debtPayment;

    @Schema(description = "Оставшаяся задолженность по кредиту после платежа")
    private BigDecimal remainingDebt;

    public PaymentScheduleElement(Integer number, LocalDate date, BigDecimal totalPayment, BigDecimal interestPayment, BigDecimal debtPayment, BigDecimal remainingDebt) {
        this.number = number;
        this.date = date;
        this.totalPayment = totalPayment;
        this.interestPayment = interestPayment;
        this.debtPayment = debtPayment;
        this.remainingDebt = remainingDebt;
    }

}

