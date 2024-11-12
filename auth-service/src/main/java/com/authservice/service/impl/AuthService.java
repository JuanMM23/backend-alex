package com.authservice.service.impl;

import com.authservice.common.dto.TokenResponse;
import com.authservice.common.dto.UserRequest;
import com.authservice.repository.UserRepository;
import com.authservice.service.IAuthService;
import com.authservice.service.IJwtService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class AuthService implements IAuthService {

    private UserRepository userRepository;
    private IJwtService jwtService;

    @Override
    public TokenResponse createUser(UserRequest userRequest) {
        return null;
    }
}
