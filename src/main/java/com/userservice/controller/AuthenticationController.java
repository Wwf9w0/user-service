package com.userservice.controller;

import com.userservice.model.JwtAuthenticationResponse;
import com.userservice.model.LoginRequest;
import com.userservice.model.LogoutTokenResponse;
import com.userservice.service.AuthenticationService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.http.HttpHeaders.AUTHORIZATION;


@RestController
@RequiredArgsConstructor
@RequestMapping("/auth")
public class AuthenticationController {

    private final AuthenticationService authenticationService;

    @PostMapping("/login")
    public ResponseEntity<JwtAuthenticationResponse> login(
            @RequestBody final LoginRequest request){
        return ResponseEntity.ok(authenticationService.authenticate(request));
    }

    @DeleteMapping("/logout")
    public ResponseEntity<LogoutTokenResponse> logout(@RequestHeader( value = AUTHORIZATION) final String token){
        return ResponseEntity.ok(authenticationService.logOut(token));
    }

    //TODO logout
}
