package com.userservice.security;

import com.userservice.service.UserDetailService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@RequiredArgsConstructor
@Slf4j
@Component
public class AuthTokenFilter extends OncePerRequestFilter {

    private final JwtTokenProvider tokenProvider;
    private final UserDetailService userDetailService;

    @Override
    protected void doFilterInternal(HttpServletRequest request,
                                    HttpServletResponse response,
                                    FilterChain filterChain)
            throws ServletException, IOException {

           final String jwtToken = tokenProvider.extractTokenRequest(request);
           if (jwtToken != null){
<<<<<<< HEAD
               if (StringUtils.isNotEmpty(jwtToken) && tokenProvider.validateJwtToken(jwtToken));
               final String id = tokenProvider.extractExtarnalNo(jwtToken);
               final UserPrincipal userPrincipal = (UserPrincipal) userDetailService.loadUserByUsername(id);
=======
               if (StringUtils.isNotEmpty(jwtToken));
               final String name = tokenProvider.extractName(jwtToken);
               final UserPrincipal userPrincipal = (UserPrincipal) userDetailService.loadUserByUsername(name);
>>>>>>> dec12f2d14bd0ff9c19329f8e16c6eda8d75cd9e

               final UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken =
                       new UsernamePasswordAuthenticationToken(userPrincipal, null, userPrincipal.getAuthorities());
               usernamePasswordAuthenticationToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
               SecurityContextHolder.getContext().setAuthentication(usernamePasswordAuthenticationToken);
           }
            filterChain.doFilter(request,response);
    }
}
