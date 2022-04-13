package com.userservice.service;

import com.userservice.model.JwtAuthenticationResponse;
import com.userservice.model.LoginRequest;
import com.userservice.model.LogoutTokenResponse;
import com.userservice.persistence.jpa.entity.RefreshTokenEntity;
import com.userservice.security.JwtTokenProvider;
import com.userservice.security.UserPrincipal;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class AuthenticationService {

    private static final String BEARER = "Bearer";
    private final AuthenticationManager authenticationManager;
    private final JwtTokenProvider jwtToken;
    private final RefreshTokenService refreshTokenService;

    public JwtAuthenticationResponse authenticate(LoginRequest request) {
        Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(request.getUsername(),
                request.getPassword()));

        SecurityContextHolder.getContext().setAuthentication(authentication);
        UserPrincipal userPrincipal = (UserPrincipal) authentication.getPrincipal();
        String token = jwtToken.generateJwtToken(authentication);
        List<String> roles = userPrincipal.getAuthorities().stream().map(GrantedAuthority::getAuthority)
                .collect(Collectors.toList());
        RefreshTokenEntity refreshTokenEntity = refreshTokenService.createRefreshToken(userPrincipal.getId());

        return JwtAuthenticationResponse.builder()
                .accessToken(token)
                .tokenType(BEARER)
                .refreshToken(refreshTokenEntity.getToken())
                .roles(roles)
                .build();
    }

    public LogoutTokenResponse logOut(final String auth){
        final String token = jwtToken.extractTokenFromAuthHeader(auth);

        return LogoutTokenResponse.builder()
                .logOut(jwtToken.invalidateToken(token)).build();
    }
}
