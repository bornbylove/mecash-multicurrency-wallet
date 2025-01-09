package com.ugo.mecash_multicurrency_wallet.dto.response;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class WalletResponse {
    private String currencyCode;
    private BigDecimal balance;
    private BigDecimal receiverWallet;
    private String responseMessage;
    private int responseCode;
}

