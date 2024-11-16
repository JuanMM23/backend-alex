package com.authservice.service.impl;

import com.authservice.common.dto.TokenResponse;
import com.authservice.common.dto.UserRequest;
import com.authservice.common.entity.UserModel;
import com.authservice.repository.UserRepository;
import com.authservice.service.IAuthService;
import com.authservice.service.IJwtService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
public class AuthService implements IAuthService {

    private UserRepository userRepository;
    private IJwtService jwtService;

    @Override
    public TokenResponse createUser(UserRequest userRequest) {
        return Optional.of(userRequest)
                .map(this::mapToEntity)
                .map(userRepository::save)
                .map(userCreated -> jwtService.generateToken(userCreated.getId()))
                .orElseThrow(() -> new RuntimeException("Error al crear usuario"));
    }

    private UserModel mapToEntity(UserRequest userRequest) {
        return UserModel.builder()
                .email(userRequest.getEmail())
                .password(userRequest.getPassword())
                .rol("USER")
                .build();
    }
}
