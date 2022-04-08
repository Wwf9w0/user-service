package com.userservice.service;

import com.userservice.model.JwtAuthenticationResponse;
import com.userservice.model.LoginRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.LockedException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
@RequiredArgsConstructor
public class AuthenticationService{

    private static final String BEARER = "Bearer";

    public JwtAuthenticationResponse authenticate(LoginRequest request) {
    return null;
    }



}
