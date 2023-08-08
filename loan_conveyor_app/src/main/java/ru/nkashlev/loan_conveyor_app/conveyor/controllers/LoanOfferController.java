package ru.nkashlev.loan_conveyor_app.conveyor.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import ru.nkashlev.loan_conveyor_app.conveyor.api.LoanOfferApi;
import ru.nkashlev.loan_conveyor_app.conveyor.exceptions.ScoringException;
import ru.nkashlev.loan_conveyor_app.conveyor.model.LoanApplicationRequestDTO;
import ru.nkashlev.loan_conveyor_app.conveyor.model.LoanOfferDTO;
import ru.nkashlev.loan_conveyor_app.conveyor.service.OfferService;
import ru.nkashlev.loan_conveyor_app.conveyor.utils.ValidateLoanApplicationRequestUtil;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class LoanOfferController implements LoanOfferApi {

    private final OfferService offerService;

    private final ValidateLoanApplicationRequestUtil validateRequestService;

    @PostMapping("/offers")
    public List<LoanOfferDTO> calculateLoanOffers(@RequestBody LoanApplicationRequestDTO request) {
        List<String> validateRequest = validateRequestService.validateRequest(request);
        if (!validateRequest.isEmpty()) {
            throw new ScoringException(validateRequest);
        }
        return offerService.generateOffers(request);
    }
}
