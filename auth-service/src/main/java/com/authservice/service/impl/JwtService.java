package com.authservice.service.impl;

import com.authservice.common.dto.TokenResponse;
import com.authservice.service.IJwtService;
import io.jsonwebtoken.Claims;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class JwtService implements IJwtService {

    @Value("${jwt.secret}")
    private final String secretToken;

    @Override
    public TokenResponse generateToken(Long userId) {
        return null;
    }

    @Override
    public Claims getClaims(String token) {
        return null;
    }

    @Override
    public boolean isExpired(String token) {
        return false;
    }

    @Override
    public Integer extractUserId(String token) {
        return null;
    }
}
