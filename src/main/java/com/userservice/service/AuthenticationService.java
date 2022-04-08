package com.userservice.service;

import com.userservice.model.JwtAuthenticationResponse;
import com.userservice.model.LoginRequest;
import com.userservice.persistence.jpa.entity.RefreshTokenEntity;
import com.userservice.security.JwtToken;
import com.userservice.security.UserPrincipal;
import lombok.RequiredArgsConstructor;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.LockedException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class AuthenticationService {

    private static final String BEARER = "Bearer";
    private final AuthenticationManager authenticationManager;
    private final JwtToken jwtToken;
    private final RefreshTokenService refreshTokenService;

    public JwtAuthenticationResponse authenticate(LoginRequest request) {
        Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(request.getUsername(),
                request.getPassword()));

        SecurityContextHolder.getContext().setAuthentication(authentication);
        UserPrincipal userPrincipal = (UserPrincipal) authentication.getPrincipal();
        String jwt = jwtToken.generateJwtToken(userPrincipal);
        List<String> roles = userPrincipal.getAuthorities().stream().map(item -> item.getAuthority())
                .collect(Collectors.toList());
        RefreshTokenEntity refreshTokenEntity = refreshTokenService.createRefreshToken(userPrincipal.getId());

        return JwtAuthenticationResponse.builder()
                .accessToken(jwt)
                .tokenType(BEARER)
                .refreshToken(refreshTokenEntity.getToken())
                .roles(roles)
                .build();
    }

}
