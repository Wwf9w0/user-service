/*
package com.userservice.security;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.Objects;
import java.util.stream.Collectors;

import static com.google.common.net.HttpHeaders.X_FORWARDED_FOR;
@Slf4j
@RequiredArgsConstructor
@Component
public class JwtToken {

    public String generateToken(final Authentication authentication, String originalIp){
        final UserPrincipal userPrincipal = (UserPrincipal) authentication.getPrincipal();
        return getAccessToken(claims(userPrincipal, originalIp));
    }

    public String getAccessToken( Claims claims){
        final Date now = new Date();
        final Date expireDate = new Date(now.getTime() + 120000);
        String token = Jwts.builder()
                .setClaims(claims)
                .setIssuedAt(now)
                .setExpiration(expireDate)
                .signWith(SignatureAlgorithm.HS512, "eq")
                .compact();
        return token;
    }

    private Claims claims (UserPrincipal userPrincipal, String originalIp){
        Claims claims = Jwts.claims().setSubject(Long.toString(userPrincipal.getId()));
        claims.put("scopes", userPrincipal.getAuthorities().stream().map(Objects::toString).collect(Collectors.toList()));
        claims.put(X_FORWARDED_FOR, originalIp);
        return claims;
    }
}
*/
