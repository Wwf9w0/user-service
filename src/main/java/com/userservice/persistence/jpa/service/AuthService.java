package com.userservice.persistence.jpa.service;

import com.userservice.persistence.jpa.entity.Token;
import com.userservice.persistence.jpa.repository.TokenRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AuthService {
        private final TokenRepository tokenRepository;

    public UserDetails getUserDetails(String token){
        Optional<Token> optionalToken = tokenRepository.findById(token);

        if (!optionalToken.isPresent()){
            return null;
        }
        return (UserDetails) optionalToken.get().getUser();
    }
}
