package ru.nkashlev.loan_conveyor_app.conveyor.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import ru.nkashlev.loan_conveyor_app.conveyor.dto.Enum.Gender;
import ru.nkashlev.loan_conveyor_app.conveyor.dto.Enum.MaritalStatus;

import java.math.BigDecimal;
import java.time.LocalDate;

@Data
@Schema(description = "Модель для скоринга заемщика")
public class ScoringDataDTO {

    @Schema(description = "Запрошенная сумма кредита")
    private BigDecimal amount;

    @Schema(description = "Срок кредита в месяцах")
    private Integer term;

    @Schema(description = "Имя заемщика")
    private String firstName;

    @Schema(description = "Фамилия заемщика")
    private String lastName;

    @Schema(description = "Отчество заемщика")
    private String middleName;

    @Schema(description = "Пол заемщика")
    private Gender gender;

    @Schema(description = "Дата рождения заемщика")
    private LocalDate birthdate;

    @Schema(description = "Серия паспорта заемщика")
    private String passportSeries;

    @Schema(description = "Номер паспорта заемщика")
    private String passportNumber;

    @Schema(description = "Дата выдачи паспорта заемщика")
    private LocalDate passportIssueDate;

    @Schema(description = "Место выдачи паспорта заемщика")
    private String passportIssueBranch;

    @Schema(description = "Семейное положение заемщика")
    private MaritalStatus maritalStatus;

    @Schema(description = "Количество иждивенцев у заемщика")
    private Integer dependentAmount;

    @Schema(description = "Информация о занятости заемщика")
    private EmploymentDTO employment;

    @Schema(description = "Номер банковского счета у заемщика")
    private String account;

    @Schema(description = "Наличие страховки у заемщика")
    private Boolean isInsuranceEnabled;

    @Schema(description = "Является ли заемщик зарплатным клиентом банка.")
    private Boolean isSalaryClient;
}
