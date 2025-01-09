package com.ugo.mecash_multicurrency_wallet.controller;

import com.ugo.mecash_multicurrency_wallet.dto.response.WalletResponse;
import com.ugo.mecash_multicurrency_wallet.service.WalletService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/wallets")
public class WalletController {
    @Autowired
    private WalletService walletService;
    @PostMapping("/deposit")
    public ResponseEntity<WalletResponse> deposit(@RequestParam Long userId,
                                                  @RequestParam String currencyCode,
                                                  @RequestParam Double amount) {
        return ResponseEntity.ok(walletService.depositMoney(userId, currencyCode, amount));
    }

    @PostMapping("/withdraw")
    public ResponseEntity<WalletResponse> withdraw(@RequestParam Long userId,
                                                   @RequestParam String currencyCode,
                                                   @RequestParam Double amount) {
        return ResponseEntity.ok(walletService.withdrawMoney(userId, currencyCode, amount));
    }

    @PostMapping("/transfer")
    public ResponseEntity<WalletResponse> transfer(@RequestParam Long userId,
                                                   @RequestParam String currencyCode,
                                                   @RequestParam Double amount,
                                                   @RequestParam Long recipientWalletId) {
        return ResponseEntity.ok(walletService.transferMoney(userId, currencyCode, amount, recipientWalletId));
    }

    @GetMapping("/balance")
    public ResponseEntity<WalletResponse> getBalance(@RequestParam Long userId,
                                                     @RequestParam String currencyCode) {
        return ResponseEntity.ok(walletService.getBalance(userId, currencyCode));
    }
}

