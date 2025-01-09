package com.ugo.mecash_multicurrency_wallet.dto.response;

import java.util.List;

public class UserResponse {
    private Long id;
    private String email;
    private String fullName;
    private List<WalletResponse> wallets;
}

