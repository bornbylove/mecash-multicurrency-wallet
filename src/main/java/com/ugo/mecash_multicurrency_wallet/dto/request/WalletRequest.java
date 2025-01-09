package com.ugo.mecash_multicurrency_wallet.dto.request;

import java.math.BigDecimal;

public class WalletRequest {
    private Long userId;
    private String currencyCode;
    private BigDecimal amount;
    private Long recipientWalletId;

}
