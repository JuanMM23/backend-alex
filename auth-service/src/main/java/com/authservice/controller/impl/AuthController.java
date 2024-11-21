package com.authservice.controller.impl;

import com.authservice.common.dto.TokenResponse;
import com.authservice.common.dto.UserRequest;
import com.authservice.controller.AuthApi;
import com.authservice.service.impl.AuthService;
import com.authservice.service.impl.UserDetailsServiceImpl;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
public class AuthController implements AuthApi {

    private final AuthService authService;
    private final UserDetailsServiceImpl userDetailsService;

    @Override
    public ResponseEntity<TokenResponse> createUser(UserRequest userRequest) {
        return ResponseEntity.ok(authService.createUser(userRequest));
    }

    @Override
    public ResponseEntity<TokenResponse> loginUser(UserRequest userRequest) {
        return ResponseEntity.ok(userDetailsService.login(userRequest));
    }

    @Override
    public ResponseEntity<String> getUser(String userId) {
        return ResponseEntity.ok(userId);
    }
}

/*Proyecto 2:

Auth de usuarios otro microservicio que se encarge de solo la autenticación de estos

nuevos endpoints:

auth/register/ tiene que devolver un token jwt con el id del usuario, guardar usuario y cifrar contraseña en la bbdd
auth/Login/ tiene que devolver un token jwt con el id del usuario, comprobar si existe, comprobar email y contraseña cifrada de bbdd*/