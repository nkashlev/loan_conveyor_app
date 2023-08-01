package ru.nkashlev.loan_conveyor_app.conveyor.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import ru.nkashlev.loan_conveyor_app.conveyor.dto.Enum.EmploymentStatus;
import ru.nkashlev.loan_conveyor_app.conveyor.dto.Enum.Position;

import java.math.BigDecimal;
@AllArgsConstructor
@Data
@Schema(description = "Данные о занятости")
public class EmploymentDTO {

    @Schema(description = "Статус занятости")
    private EmploymentStatus employmentStatus;

    @Schema(description = "ИНН работодателя")
    private String employerINN;

    @Schema(description = "Заработная плата")
    private BigDecimal salary;

    @Schema(description = "Должность")
    private Position position;

    @Schema(description = "Общий стаж работы (в месяцах)")
    private Integer workExperienceTotal;

    @Schema(description = "Стаж работы на текущем месте (в месяцах)")
    private Integer workExperienceCurrent;

//    public EmploymentDTO(EmploymentStatus employed, Position manager, BigDecimal salary, Integer workExperienceCurrent, Integer workExperienceTotal) {
//        this.employed = employed;
//        this.manager = manager;
//        this.salary = salary;
//        this.workExperienceCurrent = workExperienceCurrent;
//        this.workExperienceTotal = workExperienceTotal;
//    }
}
