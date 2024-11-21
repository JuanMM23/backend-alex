package com.authservice.service.impl;

import com.authservice.common.dto.TokenResponse;
import com.authservice.common.dto.UserRequest;
import com.authservice.common.entity.UserModel;
import com.authservice.repository.UserRepository;
import com.authservice.service.IJwtService;
import lombok.AllArgsConstructor;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class UserDetailsServiceImpl implements UserDetailsService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final IJwtService jwtService;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return userRepository.findByEmail(username).orElseThrow(() -> new BadCredentialsException("Credenciales inválidas"));
    }

    public Long getUserIdByUsername(String username) {
        UserDetails userDetails = loadUserByUsername(username);
        return ((UserModel) userDetails).getId();
    }

    public TokenResponse login(UserRequest userRequest) {
        String username = userRequest.getEmail();
        if (userRequest.getPassword() == null || userRequest.getPassword().isBlank()) {
            throw new BadCredentialsException("Credenciales inválidas");
        }
        String password = userRequest.getPassword();

        Authentication authentication = this.authenticate(username, password);
        SecurityContextHolder.getContext().setAuthentication(authentication);

        return jwtService.generateToken(getUserIdByUsername(username));
    }

    private Authentication authenticate(String username, String password) {
        UserDetails user = this.loadUserByUsername(username);

        if (user == null) {
            throw new BadCredentialsException("Credenciales inválidas");
        }

        if (!passwordEncoder.matches(password, user.getPassword())) {
            throw new BadCredentialsException("Credenciales inválidas");
        }

        return new UsernamePasswordAuthenticationToken(username, user.getPassword(), user.getAuthorities());
    }
}
