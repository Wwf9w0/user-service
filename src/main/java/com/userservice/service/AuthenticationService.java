/*
package com.userservice.service;

import com.userservice.model.JwtAuthenticationResponse;
import com.userservice.model.LoginRequest;
import com.userservice.persistence.jpa.entity.UserEntity;
import com.userservice.persistence.jpa.entity.UserProfileEntity;
import com.userservice.persistence.jpa.enums.UserStatus;
import com.userservice.persistence.jpa.repository.UserRepository;
import com.userservice.security.JwtToken;
import com.userservice.security.UserPrincipal;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import lombok.RequiredArgsConstructor;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.LockedException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Objects;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AuthenticationService {

    private final ApplicationEventPublisher applicationEventPublisher;
    private final UserService userService;

    public JwtAuthenticationResponse authenticate( LoginRequest request){
        Optional<UserProfileEntity> inDb = userService.findByUserName(request.getUsername());
        String token = Jwts.builder().setSubject(""+inDb.get().getNickName())
                .signWith(SignatureAlgorithm.HS512, "my-app-secret").compact();


        return JwtAuthenticationResponse.builder()
                .accessToken(token)
                .tokenType("Bearer")
                .reactivated(true)
                .build();
    }

    private void failingCount(UserPrincipal userPrincipal){
        if (Objects.nonNull(userPrincipal.getFailedLoginCount())
                && userPrincipal.getFailedLoginCount() > 0){
            applicationEventPublisher.publishEvent(userPrincipal.getId());
        }
    }
    private void assertLogin(){
        throw new LockedException("Too many failure login attemt!");
    }
}
*/
