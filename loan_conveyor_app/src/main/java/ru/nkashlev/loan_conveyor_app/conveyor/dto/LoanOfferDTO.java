package ru.nkashlev.loan_conveyor_app.conveyor.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.math.BigDecimal;
// данные об условиях предложения по кредиту.
@Data
@Schema(description = "Модель данных, представляющая информацию о предложении кредита.")
public class LoanOfferDTO {

    @Schema(description = "Идентификатор заявки на кредит.")
    private Long applicationId;

    @Schema(description = "Запрошенная сумма кредита.")
    private BigDecimal requestedAmount;

    @Schema(description = "Общая сумма кредита.")
    private BigDecimal totalAmount;

    @Schema(description = "Срок кредита в месяцах")
    private Integer term;

    @Schema(description = "Ежемесячный платеж по кредиту.")
    private BigDecimal monthlyPayment;

    @Schema(description = "Процентная ставка по кредиту.")
    private BigDecimal rate;

    @Schema(description = "Флаг, указывающий, включена ли страховка.")
    private Boolean isInsuranceEnabled;

    @Schema(description = "Флаг, указывающий, является ли клиент зарплатным.")
    private Boolean isSalaryClient;
}
