package com.ugo.mecash_multicurrency_wallet.enums;

public enum ResponseMessage {

    ACCOUNT_NUMBER_CANNOT_BE_FOUND("404");

    String statusCode;

        private ResponseMessage(String statusCode){
            this.statusCode = statusCode;
        }

        public String getStatusCode(){
            return statusCode;
        }

}
