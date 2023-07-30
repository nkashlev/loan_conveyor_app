package ru.nkashlev.loan_conveyor_app.conveyor.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import ru.nkashlev.loan_conveyor_app.conveyor.dto.Enum.EmploymentStatus;
import ru.nkashlev.loan_conveyor_app.conveyor.dto.Enum.Position;

import java.math.BigDecimal;

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
}
