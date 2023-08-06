package ru.nkashlev.loan_conveyor_app.conveyor.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.nkashlev.loan_conveyor_app.conveyor.model.LoanApplicationRequestDTO;
import ru.nkashlev.loan_conveyor_app.conveyor.model.LoanOfferDTO;
import ru.nkashlev.loan_conveyor_app.conveyor.service.OfferService;
import ru.nkashlev.loan_conveyor_app.conveyor.utils.ValidateLoanApplicationRequestUtil;

import java.util.List;

@RestController
@RequestMapping("/conveyor")
@RequiredArgsConstructor
public class LoanOfferController {
    private final OfferService offerService;
    private final ValidateLoanApplicationRequestUtil validateRequestService;
    @PostMapping("/offers")
    public List<LoanOfferDTO> calculateLoanOffers(@RequestBody LoanApplicationRequestDTO request) {
        if (!validateRequestService.validateRequest(request)) {
            throw new IllegalArgumentException("Invalid loan application request!");
        }
        return offerService.generateOffers(request);
    }
}
