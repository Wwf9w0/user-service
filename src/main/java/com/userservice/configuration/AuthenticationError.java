package com.userservice.configuration;

import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Date;

import static com.userservice.configuration.FlushError.flushError;


@Slf4j
@Component
public class AuthenticationError implements AuthenticationEntryPoint {

    private static final int UNAUTHENTICATED = 101;

    @Override
    public void commence(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, AuthenticationException e) {
        Error error = Error.builder().code(UNAUTHENTICATED).message("Authentication error!").timestamp(new Date().getTime()).build();
        try {
            flushError(httpServletResponse, error);
        } catch (Exception ex) {
            ex.printStackTrace();
        }


    }

}
