package ru.nkashlev.loan_conveyor_app.conveyor.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDate;

// данные о заявке на кредит
@AllArgsConstructor
@Data
@Schema(description = "Модель заявки")
public class LoanApplicationRequestDTO {

    @Schema(description = "Запрашиваемая сумма")
    private BigDecimal amount;

    @Schema(description = "Срок кредита в месяцах")
    private Integer term;

    @Schema(description = "Имя")
    private String firstName;

    @Schema(description = "Фамилия")
    private String lastName;

    @Schema(description = "Отчество")
    private String middleName;

    @Schema(description = "Электронная почта")
    private String email;

    @Schema(description = "Дата рождения")
    private LocalDate birthdate;

    @Schema(description = "Серия паспорта")
    private String passportSeries;

    @Schema(description = "Номер паспорта")
    private String passportNumber;
}

