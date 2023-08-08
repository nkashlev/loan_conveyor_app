package ru.nkashlev.loan_conveyor_app.conveyor.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import ru.nkashlev.loan_conveyor_app.conveyor.api.LoanCalculationApi;
import ru.nkashlev.loan_conveyor_app.conveyor.model.CreditDTO;
import ru.nkashlev.loan_conveyor_app.conveyor.model.ScoringDataDTO;
import ru.nkashlev.loan_conveyor_app.conveyor.service.ScoringService;

@RestController
@RequiredArgsConstructor
public class LoanScoringController implements LoanCalculationApi {
    private final ScoringService scoringService;

    @PostMapping("/calculation")
    public CreditDTO scoringLoanOffer(@RequestBody ScoringDataDTO request) {
        return scoringService.scoringOffer(request);
    }
}
