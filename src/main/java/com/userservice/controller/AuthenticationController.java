package com.userservice.controller;

import com.userservice.model.JwtAuthenticationResponse;
import com.userservice.model.LoginRequest;
import com.userservice.service.AuthenticationService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static com.google.common.net.HttpHeaders.X_FORWARDED_FOR;


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
}
