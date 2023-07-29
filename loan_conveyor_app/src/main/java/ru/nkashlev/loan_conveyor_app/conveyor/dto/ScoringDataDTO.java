package ru.nkashlev.loan_conveyor_app.conveyor.dto;

import lombok.Data;
import ru.nkashlev.loan_conveyor_app.conveyor.dto.Enum.Gender;
import ru.nkashlev.loan_conveyor_app.conveyor.dto.Enum.MaritalStatus;

import java.math.BigDecimal;
import java.time.LocalDate;
//данные для расчета скоринга заемщика объект данных о рейтинге заявки, содержащий идентификатор заявки, рейтинг и решение.
@Data
public class ScoringDataDTO {

    private BigDecimal amount;
    private Integer term;
    private String firstName;
    private String lastName;
    private String middleName;
    private Gender gender;
    private LocalDate birthdate;
    private String passportSeries;
    private String passportNumber;
    private LocalDate passportIssueDate;
    private String passportIssueBranch;
    private MaritalStatus maritalStatus;
    private Integer dependentAmount;
    private EmploymentDTO employment;
    private String account;
    private Boolean isInsuranceEnabled;
    private Boolean isSalaryClient;
}
