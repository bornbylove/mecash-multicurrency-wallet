package com.ugo.mecash_multicurrency_wallet.service;

import com.ugo.mecash_multicurrency_wallet.dto.response.WalletResponse;
import org.springframework.stereotype.Service;

@Service
public interface WalletService {
    WalletResponse depositMoney(Long userId, String currencyCode, Double amount);
    WalletResponse withdrawMoney(Long userId, String currencyCode, Double amount);
    WalletResponse transferMoney(Long userId, String currencyCode, Double amount, Long recipientWalletId);
    WalletResponse getBalance(Long userId, String currencyCode);
}

