package com.userservice.security;

import com.userservice.configuration.JwtProperties;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.MalformedJwtException;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.SignatureException;
import io.jsonwebtoken.UnsupportedJwtException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
@Slf4j
@RequiredArgsConstructor
public class JwtToken {
    private final JwtProperties properties;

    public String generateJwtToken(UserPrincipal userPrincipal){
        return generateTokenFromUserName(userPrincipal.getUsername());
    }

    public String generateTokenFromUserName(String userName){
        return Jwts.builder().setSubject(userName).setIssuedAt(new Date())
                .setExpiration(new Date(new Date().getTime() + properties.getJwtExpiretionMs()))
                .signWith(SignatureAlgorithm.HS512, properties.getJwtSecret())
                .compact();
    }

    public boolean validateJwtToken(String authToken){
        try{
            Jwts.parser().setSigningKey(properties.getJwtSecret()).parseClaimsJws(authToken);
            return true;
        }catch (SignatureException e) {
            log.error("Invalid JWT signature: {}", e.getMessage());
        } catch (MalformedJwtException e) {
            log.error("Invalid JWT token: {}", e.getMessage());
        } catch (ExpiredJwtException e) {
            log.error("JWT token is expired: {}", e.getMessage());
        } catch (UnsupportedJwtException e) {
            log.error("JWT token is unsupported: {}", e.getMessage());
        } catch (IllegalArgumentException e) {
            log.error("JWT claims string is empty: {}", e.getMessage());
        }
        return false;
    }
}
