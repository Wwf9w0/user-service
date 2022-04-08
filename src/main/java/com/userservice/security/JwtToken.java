
package com.userservice.security;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.Objects;
import java.util.stream.Collectors;

import static com.google.common.net.HttpHeaders.X_FORWARDED_FOR;
@Slf4j
@RequiredArgsConstructor
@Component
public class JwtToken {

/*    public String generateToken(final Authentication authentication){
        final UserPrincipal userPrincipal = (UserPrincipal) authentication.getPrincipal();
        return getAccessToken(claims(userPrincipal));
    }*/

    public String getAccessToken( Claims claims){
        final Date now = new Date();
        final Date expireDate = new Date(now.getTime() + 120000);
        return Jwts.builder()
                .setClaims(claims)
                .setIssuedAt(now)
                .setExpiration(expireDate)
                .signWith(SignatureAlgorithm.HS512, "eq")
                .compact();
    }

 /*   private Claims claims (UserPrincipal userPrincipal){
        Claims claims = Jwts.claims().setSubject(Long.toString(userPrincipal.getId()));
        claims.put("scopes", userPrincipal.getAuthorities().stream().map(Objects::toString).collect(Collectors.toList()));
        return claims;
    }*/
}

