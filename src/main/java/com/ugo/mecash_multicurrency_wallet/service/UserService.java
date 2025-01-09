package com.ugo.mecash_multicurrency_wallet.service;

import com.ugo.mecash_multicurrency_wallet.dto.request.UserRequest;
import com.ugo.mecash_multicurrency_wallet.dto.response.UserResponse;
import org.springframework.stereotype.Service;

@Service
public interface UserService {
    UserResponse registerUser(UserRequest request);
    UserResponse loginUser(UserRequest request);
}

