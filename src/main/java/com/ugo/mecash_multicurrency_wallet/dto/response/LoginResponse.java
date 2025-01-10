package com.ugo.mecash_multicurrency_wallet.dto.response;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@RequiredArgsConstructor
@Builder
public class LoginResponse {
    private String accessToken;
    private String refreshToken;
    private String message;
    private Boolean firstTimeLogin;
    private String role;
    private String issuedAt;
    private String expirationDate;

    @Override
    public String toString() {
        return "LoginResponse{" +
                "accessToken='" + accessToken + '\'' +
                // ", refreshToken='" + refreshToken + '\'' +
                ", message='" + message + '\'' +
                ", firstTimeLogin=" + firstTimeLogin +
                ", role='" + role + '\'' +
                ", issuedAt='" + issuedAt + '\'' +
                ", expirationDate='" + expirationDate + '\'' +
                '}';
    }
}
