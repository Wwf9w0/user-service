package com.userservice.service;

import com.userservice.model.JwtAuthenticationResponse;
import com.userservice.model.LoginRequest;
import com.userservice.persistence.jpa.UserEntity;
import com.userservice.persistence.jpa.UserStatus;
import com.userservice.repository.UserRepository;
import com.userservice.security.UserPrincipal;
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
public class AuthenticationService {

    private final AuthenticationManager authenticationManager;
    private final Jwt
    private final UserRepository userRepository;
    private final ApplicationEventPublisher applicationEventPublisher;
    private static String BEARER = "Bearer";

    public JwtAuthenticationResponse authenticate(String originalIp, LoginRequest request){
        Authentication authentication = authenticationManager
                .authenticate(new UsernamePasswordAuthenticationToken(request.getUsername()
        , request.getPassword()));
        SecurityContextHolder.getContext().setAuthentication(authentication);
        final UserPrincipal userPrincipal = (UserPrincipal) authentication.getPrincipal();
        assertLogin(userPrincipal);

        UserEntity user = userRepository.findById(userPrincipal.getId()).orElse(null);
        user.setStatus(UserStatus.ACTIVE.getStatus());
        userRepository.save(user);
        failingCount(userPrincipal);
        return JwtAuthenticationResponse.builder()
                .tokenType(BEARER)
                .accessToken()

    }

    private void failingCount(UserPrincipal userPrincipal){
        if (Objects.nonNull(userPrincipal.getFailedLoginCount())
                && userPrincipal.getFailedLoginCount() > 0){
            applicationEventPublisher.publishEvent(userPrincipal.getId());
        }
    }
    private void assertLogin(UserPrincipal userPrincipal){
        if (Objects.nonNull(userPrincipal.getFailedLoginCount() >= 3)){
            throw new LockedException("Too many failure login attemt!");
        }
    }
}
