package org.example.btth_ss11.controllers;

import lombok.RequiredArgsConstructor;
import org.example.btth_ss11.models.entities.Transfer;
import org.example.btth_ss11.models.services.ITransferService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/transfers")
@RequiredArgsConstructor
public class TransferController {
    private final ITransferService transferService;

    @PostMapping
    public ResponseEntity<Transfer> insufficientBalance(
            @RequestParam(name = "accountId") Long accountId,
            @RequestParam(name = "amount") Double amount
    ) {
        return ResponseEntity.ok(
                transferService.precessWithdrawal(accountId, amount)
        );
    }

}
