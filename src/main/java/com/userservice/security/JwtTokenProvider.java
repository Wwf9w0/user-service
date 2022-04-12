package com.userservice.security;

import com.userservice.configuration.JwtProperties;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.MalformedJwtException;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.SignatureException;
import io.jsonwebtoken.UnsupportedJwtException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import java.time.Instant;
import java.util.Date;
import java.util.Objects;
import java.util.stream.Collectors;

import static com.google.common.net.HttpHeaders.AUTHORIZATION;
import static org.apache.commons.lang3.StringUtils.EMPTY;
import static org.apache.commons.lang3.StringUtils.SPACE;

@Component
@RequiredArgsConstructor
@Slf4j
public class JwtTokenProvider {

    private static final String BEARER = "Bearer";
    private final JwtProperties properties;


    public String generateJwtToken(Authentication authentication) {
        final UserPrincipal userPrincipal = (UserPrincipal) authentication.getPrincipal();
        return generateAccessToken(userPrincipal.getId(), populateClaims(userPrincipal));
    }

    public String generateAccessToken(Long id, Claims claims) {
        final Date now = new Date();
        final Date expireDate =  Date.from(Instant.ofEpochSecond(now.getTime() + properties.getJwtExpiretionMs()));
        return Jwts.builder().setClaims(claims)
                .setIssuedAt(now)
                .setExpiration(expireDate)
                .signWith(SignatureAlgorithm.HS512, properties.getJwtSecret())
                .compact();
    }

    public boolean validateJwtToken(String authToken) {
        try {
            Jwts.parser().setSigningKey(properties.getJwtSecret()).parseClaimsJws(authToken);
            return true;
        } catch (SignatureException e) {
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

    public Claims populateClaims(UserPrincipal userPrincipal) {
        Claims claims = Jwts.claims().setSubject(userPrincipal.getUsername());
        claims.put("scopes", userPrincipal.getAuthorities().stream().map(Objects::toString).collect(Collectors.toList()));
        return claims;
    }

    public String extractTokenRequest(final HttpServletRequest request) {
        final String bearerToken = request.getHeader(AUTHORIZATION);
        return extractTokenFromAuthHeader(bearerToken);
    }

    public String extractTokenFromAuthHeader(final String authHeader) {
        if (StringUtils.isEmpty(authHeader)) {
            return EMPTY;
        }
        if (!authHeader.startsWith(BEARER + SPACE)) {
            return EMPTY;
        }
        return authHeader.split(SPACE)[1];
    }


    public Claims getClaimsByToken(String token) {
        return Jwts.parser()
                .setSigningKey(properties.getJwtSecret())
                .parseClaimsJws(token)
                .getBody();
    }

    public String extractExtarnalNo(final String token){
        return getClaimsByToken(token).getSubject();
    }

}
