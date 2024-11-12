package com.authservice.controller.impl;

import com.authservice.common.dto.TokenResponse;
import com.authservice.common.dto.UserRequest;
import com.authservice.controller.AuthApi;
import com.authservice.service.impl.AuthService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
public class AuthController implements AuthApi {

    private final AuthService authService;
    @Override
    public ResponseEntity<TokenResponse> createUser(UserRequest userRequest) {
        return ResponseEntity.ok(authService.createUser(userRequest));
    }
}
