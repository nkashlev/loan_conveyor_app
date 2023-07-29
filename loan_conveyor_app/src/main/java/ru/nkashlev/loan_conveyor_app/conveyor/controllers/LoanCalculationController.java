package ru.nkashlev.loan_conveyor_app.conveyor.controllers;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.nkashlev.loan_conveyor_app.conveyor.dto.CreditDTO;
import ru.nkashlev.loan_conveyor_app.conveyor.dto.ScoringDataDTO;
//todo
@RestController
@RequestMapping("/conveyor")
public class LoanCalculationController {

    @PostMapping("/calculation")
    public CreditDTO validationLoanOffers(@RequestBody ScoringDataDTO request) {

        return null;

    }

}
