package com.ugo.mecash_multicurrency_wallet.dto.response;

import java.time.LocalDateTime;

public class TransactionResponse {
    private String type;
    private String currencyCode;
    private Double amount;
    private LocalDateTime transactionDate;
}

