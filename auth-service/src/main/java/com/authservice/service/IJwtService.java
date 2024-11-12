package com.authservice.service;

import com.authservice.common.dto.TokenResponse;
import io.jsonwebtoken.Claims;

public interface IJwtService {
    TokenResponse generateToken(Long userId);
    Claims getClaims(String token);
    boolean isExpired(String token);
    Integer extractUserId(String token);
}
