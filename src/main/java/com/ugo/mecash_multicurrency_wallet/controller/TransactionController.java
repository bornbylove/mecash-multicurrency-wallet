package com.ugo.mecash_multicurrency_wallet.controller;

import com.ugo.mecash_multicurrency_wallet.dto.request.WalletRequest;
import com.ugo.mecash_multicurrency_wallet.dto.response.TransactionResponse;
import com.ugo.mecash_multicurrency_wallet.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/transactions")
public class TransactionController {
    @Autowired
    private TransactionService transactionService;
    @GetMapping("/{walletId}")
    public ResponseEntity<List<TransactionResponse>> getTransactionHistory(@ModelAttribute WalletRequest walletRequest) {
        return ResponseEntity.ok(transactionService.getTransactionHistory(walletRequest));
    }
}

