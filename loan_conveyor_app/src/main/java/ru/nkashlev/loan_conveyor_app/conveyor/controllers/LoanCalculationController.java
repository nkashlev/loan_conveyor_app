package ru.nkashlev.loan_conveyor_app.conveyor.controllers;

import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.nkashlev.loan_conveyor_app.conveyor.dto.CreditDTO;
import ru.nkashlev.loan_conveyor_app.conveyor.dto.ScoringDataDTO;
import ru.nkashlev.loan_conveyor_app.conveyor.service.ScoringService;

@RestController
@RequestMapping("/conveyor")
public class LoanCalculationController {

    private final ScoringService scoringService;

    public LoanCalculationController(ScoringService scoringService) {
        this.scoringService = scoringService;
    }

    @PostMapping("/calculation")
    @ApiOperation("Рассчитать кредит")
    public CreditDTO validationLoanOffers(@RequestBody ScoringDataDTO request) {
        return scoringService.calculate(request);
    }

}
