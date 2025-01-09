package com.ugo.mecash_multicurrency_wallet.enums;

public enum ResponseMessage {

    ACCOUNT_NUMBER_CANNOT_BE_FOUND("404"), INVALID_INPUT_PARAMETER("404"), SUCCESS("200"), WALLET_NOT_FOUND("404"), INTERNAL_ERROR("500"), MAX_BALANCE_EXCEEDED(""), MAX_TRANSACTIONS_EXCEEDED(""), WALLET_IS_NOT_ACTIVE(""), INSUFFICIENT_FUNDS(""), RECIPIENT_WALLET_NOT_FOUND(""), USER_WALLET_NOT_FOUND(""), ACCESS_DENIED("");

    String statusCode;

        private ResponseMessage(String statusCode){
            this.statusCode = statusCode;
        }

        public String getStatusCode(){
            return statusCode;
        }

}
