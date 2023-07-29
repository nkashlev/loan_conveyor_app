package ru.nkashlev.loan_conveyor_app.conveyor.dto;


import lombok.Data;
import ru.nkashlev.loan_conveyor_app.conveyor.dto.Enum.EmploymentStatus;
import ru.nkashlev.loan_conveyor_app.conveyor.dto.Enum.Position;

import java.math.BigDecimal;
//данные о месте работы заемщика. Объект данных о занятости, содержащий идентификатор заявки, название работодателя, должность и ежемесячный доход.
@Data
public class EmploymentDTO {

    private EmploymentStatus employmentStatus;
    private String employerINN;
    private BigDecimal salary;
    private Position position;
    private Integer workExperienceTotal;
    private Integer workExperienceCurrent;
}
