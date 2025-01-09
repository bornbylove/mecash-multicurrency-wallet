package com.ugo.mecash_multicurrency_wallet.service.serviceImpl;

import com.ugo.mecash_multicurrency_wallet.dto.request.WalletRequest;
import com.ugo.mecash_multicurrency_wallet.dto.response.WalletResponse;
import com.ugo.mecash_multicurrency_wallet.service.WalletService;
import lombok.extern.slf4j.Slf4j;

import java.math.BigDecimal;

@Slf4j
public class WalletServiceImpl implements WalletService {
    @Override
    public WalletResponse depositMoney(WalletRequest walletRequest) {
        try{

        }catch(Exception ex){
            log.error("");
        }
        return null;
    }

    @Override
    public WalletResponse withdrawMoney(WalletRequest walletRequest) {
        return null;
    }

    @Override
    public WalletResponse transferMoney(WalletRequest walletRequest) {
        return null;
    }

    @Override
    public WalletResponse getBalance(WalletRequest walletRequest) {
        return null;
    }
}
