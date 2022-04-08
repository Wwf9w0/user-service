package com.userservice.persistence.jpa.service;

import com.userservice.persistence.jpa.entity.Token;
import com.userservice.persistence.jpa.entity.UserEntity;
import com.userservice.persistence.jpa.repository.TokenRepository;
import com.userservice.persistence.jpa.repository.UserRepository;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtParser;
import io.jsonwebtoken.Jwts;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AuthService {
        private final UserRepository userRepository;

    public UserEntity getUserDetails(String token){
        JwtParser parser = Jwts.parser().setSigningKey("my-app-secret");
        try{
            parser.parse(token);
            Claims claims = parser.parseClaimsJws(token).getBody();
            Long userNo = Long.valueOf(claims.getSubject());
            UserEntity user = (getByUserId(userNo));
            return user;
        }catch (Exception e){
            throw new RuntimeException();
        }
    }

    private UserEntity getByUserId(Long userId){
        return userRepository.findById(userId).orElse(null);
    }
}
