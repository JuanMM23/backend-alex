package com.authservice.service.impl;

import com.authservice.common.dto.TokenResponse;
import com.authservice.service.IJwtService;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.Date;

import static io.jsonwebtoken.Jwts.*;

@Service
public class JwtService implements IJwtService {

    private final String secretToken;

    public JwtService(@Value("${jwt.secret}") String secretToken) {
        this.secretToken = secretToken;
    }

    @Override
    public TokenResponse generateToken(Long userId) {
        Date expirationDate = new Date(Long.MAX_VALUE);
        String token = builder()
                .setSubject(String.valueOf(userId))
                .setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(expirationDate)
                .signWith(SignatureAlgorithm.HS512, this.secretToken)
                .compact();

        return TokenResponse.builder()
                .accesToken(token)
                .build();
    }

    @Override
    public Claims getClaims(String token) {
        return Jwts.parser()
                .setSigningKey(secretToken) // Clave secreta para validar el token
                .build()
                .parseClaimsJws(token) // Analizar el token y obtener los claims
                .getBody();
    }

    @Override
    public boolean isExpired(String token) {
        try {
            return getClaims(token).getExpiration().before(new Date());
        } catch (Exception e) {
            return false;
        }
    }

    @Override
    public Integer extractUserId(String token) {
        try {
            return Integer.parseInt(getClaims(token).getSubject());
        } catch (Exception e) {
            return null;
        }
    }
}
