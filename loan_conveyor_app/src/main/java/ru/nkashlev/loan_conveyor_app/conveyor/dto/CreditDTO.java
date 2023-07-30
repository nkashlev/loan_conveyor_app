package ru.nkashlev.loan_conveyor_app.conveyor.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.math.BigDecimal;
import java.util.List;

@Data
@Schema(description = "DTO для данных о кредите")
public class CreditDTO {

    @Schema(description = "Сумма кредита")
    private BigDecimal amount;

    @Schema(description = "Срок кредита в месяцах")
    private Integer term;

    @Schema(description = "Ежемесячный платеж по кредиту")
    private BigDecimal monthlyPayment;

    @Schema(description = "Процентная ставка по кредиту")
    private BigDecimal rate;

    @Schema(description = "Полная стоимость кредита (ПСК)")
    private BigDecimal psk;

    @Schema(description = "Наличие страховки у заемщика")
    private Boolean isInsuranceEnabled;

    @Schema(description = "Является ли заемщик зарплатным клиентом банка")
    private Boolean isSalaryClient;

    @Schema(description = "График платежей по кредиту")
    private List<PaymentScheduleElement> paymentSchedule;
}
