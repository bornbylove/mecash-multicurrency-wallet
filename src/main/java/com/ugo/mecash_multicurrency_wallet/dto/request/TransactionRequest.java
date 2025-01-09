package com.ugo.mecash_multicurrency_wallet.dto.request;

public class TransactionRequest {
    private String type;
    private String currencyCode;
    private Double amount;
    private Long recipientWalletId;
}

