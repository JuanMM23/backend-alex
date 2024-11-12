package com.authservice.service;

import com.authservice.common.dto.TokenResponse;
import com.authservice.common.dto.UserRequest;

public interface IAuthService {

    TokenResponse createUser(UserRequest userRequest);
}
