package com.ugo.mecash_multicurrency_wallet.controller;

import com.ugo.mecash_multicurrency_wallet.dto.request.WalletRequest;
import com.ugo.mecash_multicurrency_wallet.dto.response.WalletResponse;
import com.ugo.mecash_multicurrency_wallet.service.WalletService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;

@RestController
@RequestMapping("/api/wallets")
public class WalletController {
    @Autowired
    private WalletService walletService;
    @PostMapping("/deposit")
    public ResponseEntity<WalletResponse> deposit(@RequestBody WalletRequest walletRequest) {
        return ResponseEntity.ok(walletService.depositMoney(walletRequest));
    }

    @PostMapping("/withdraw")
    public ResponseEntity<WalletResponse> withdraw(@RequestBody WalletRequest walletRequest) {
        return ResponseEntity.ok(walletService.withdrawMoney(walletRequest));
    }

    @PostMapping("/transfer")
    public ResponseEntity<WalletResponse> transfer(@RequestBody WalletRequest walletRequest) {
        return ResponseEntity.ok(walletService.transferMoney(walletRequest));
    }

    @GetMapping("/balance")
    public ResponseEntity<WalletResponse> getBalance(@ModelAttribute WalletRequest walletRequest) {
        return ResponseEntity.ok(walletService.getBalance(walletRequest));
    }
}

