package ru.nkashlev.loan_conveyor_app.conveyor.dto;

import lombok.Data;
import ru.nkashlev.loan_conveyor_app.conveyor.dto.Enum.LoanStatus;
import ru.nkashlev.loan_conveyor_app.conveyor.dto.Enum.LoanStatusChangeType;

import java.time.LocalDateTime;
// объект истории статусов заявки, содержащий идентификатор заявки, перечисление статусов и дату.
@Data
public class ApplicationStatusHistoryDTO {
    private Enum<LoanStatus> status;
    private LocalDateTime time;
    private Enum<LoanStatusChangeType> changeType;
}
