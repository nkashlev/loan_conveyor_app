package ru.nkashlev.loan_conveyor_app.conveyor.controllers;

import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.nkashlev.loan_conveyor_app.conveyor.dto.LoanApplicationRequestDTO;
import ru.nkashlev.loan_conveyor_app.conveyor.dto.LoanOfferDTO;
import ru.nkashlev.loan_conveyor_app.conveyor.service.LoanService;

import java.util.List;

@RestController
@RequestMapping("/conveyor")
public class LoanOfferController {
    private final LoanService loanService;

    public LoanOfferController(LoanService loanService) {
        this.loanService = loanService;
    }

    @PostMapping("/offers")
    @ApiOperation("Создать заявку")
    public List<LoanOfferDTO> calculateLoanOffers(@RequestBody LoanApplicationRequestDTO request) {
        // реализация метода расчёта возможных условий кредита
        if (!loanService.validateRequest(request)) {
            throw new IllegalArgumentException("Invalid loan application request!");
        }
        return loanService.getLoanOffers(request);
    }
}
