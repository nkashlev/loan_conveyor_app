package ru.nkashlev.loan_conveyor_app.conveyor.dto;

import lombok.Data;
import ru.nkashlev.loan_conveyor_app.conveyor.dto.Enum.Gender;
import ru.nkashlev.loan_conveyor_app.conveyor.dto.Enum.MaritalStatus;

import java.time.LocalDate;
// объект запроса на завершение регистрации, содержащий имя, фамилию, электронную почту и пароль.
@Data
public class FinishRegistrationRequestDTO {
    private Gender gender;
    private MaritalStatus maritalStatus;
    private Integer dependentAmount;
    private LocalDate passportIssueDate;
    private String passportIssueBranch;
    private EmploymentDTO employment;
    private String account;
}
