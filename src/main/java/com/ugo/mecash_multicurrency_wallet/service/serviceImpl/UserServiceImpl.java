package com.ugo.mecash_multicurrency_wallet.service.serviceImpl;

import com.ugo.mecash_multicurrency_wallet.config.JwtService;
import com.ugo.mecash_multicurrency_wallet.dto.request.UserRequest;
import com.ugo.mecash_multicurrency_wallet.dto.response.LoginResponse;
import com.ugo.mecash_multicurrency_wallet.dto.response.UserResponse;
import com.ugo.mecash_multicurrency_wallet.entity.User;
import com.ugo.mecash_multicurrency_wallet.service.UserDetailsImp;
import com.ugo.mecash_multicurrency_wallet.service.UserService;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.InternalAuthenticationServiceException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
@Slf4j
public class UserServiceImpl implements UserService {

    private final AuthenticationManager authenticationManager;
    private JwtService jwtService;
    private PasswordEncoder passwordEncoder;
    private LoginResponse loginResponse;

    public UserServiceImpl(AuthenticationManager authenticationManager) {
        this.authenticationManager = authenticationManager;
    }

    @Override
    public UserResponse registerUser(UserRequest request) {
        return null;
    }

    @Override
    public LoginResponse loginUser(UserRequest request, HttpServletResponse httpServletResponse) {
        Authentication authentication;
        try {
            authentication = authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(
                            request.getEmail(),
                            request.getPassword()
                    )
            );
        } catch (BadCredentialsException e) {
            log.error("Invalid username or password for user: {}", request.getEmail());
            throw new IllegalArgumentException("Incorrect username or password.");
        } catch (InternalAuthenticationServiceException e) {
            log.error("failed to load userDetails, Internal server error during authentication for user: {}", userRequest.getEmail(), e);
            throw new IllegalStateException("Internal server error");
        }

        UserDetailsImp userDetails = (UserDetailsImp) authentication.getPrincipal();
        User user = userDetails.getUser();

        if (passwordEncoder.matches("Password", user.getPassword())) {
            log.info("User {} is logging in for the first time and needs to change their password.", user.getEmail());
            return LoginResponse.builder()
                    .message("Please change your password.")
                    .firstTimeLogin(true)
                    .build();
        }
        log.info("############# Log before generating token ##################");
        String roleName = userDetails.getUser().getRole().getRoleName();
        String jwtToken = jwtService.generateAccessToken(userDetails);
        String refreshToken = jwtService.generateRefreshToken(userDetails);

        log.info("Generated Access token" + jwtToken);

        log.info("Generated Refresh Token" + refreshToken);
        Date issuedAt = jwtService.extractAccessTokenIssuedAt(jwtToken);
        Date expirationDate = jwtService.extractAccessTokenExpiration(jwtToken);

        createRefreshTokenCookie(httpServletResponse, refreshToken);
        //  saveUserRefreshToken(user, refreshToken);

        return LoginResponse.builder()
                .accessToken(jwtToken)
                .refreshToken(refreshToken)
                .role(roleName)
                .issuedAt(issuedAt.toString())
                .expirationDate(expirationDate.toString())
                .message("Login successful")
                .build();
    }

    private void createRefreshTokenCookie(HttpServletResponse httpServletResponse, String refreshToken) {
        return;
    }
}
