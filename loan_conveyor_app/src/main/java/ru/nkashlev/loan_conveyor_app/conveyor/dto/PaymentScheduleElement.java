package ru.nkashlev.loan_conveyor_app.conveyor.dto;

import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDate;
//данные об элементе графика платежей по кредиту.
@Data
public class PaymentScheduleElement {
    private Integer number;
    private LocalDate date;
    private BigDecimal totalPayment;
    private BigDecimal interestPayment;
    private BigDecimal debtPayment;
    private BigDecimal remainingDebt;
}
