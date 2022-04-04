package com.userservice.controller;

import com.userservice.persistence.jpa.entity.UserProfileEntity;
import com.userservice.security.UserPrincipal;
import com.userservice.service.UserProfileService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping("/user-profile")
public class UserProfileController {

    private final UserProfileService userProfileService;

    @GetMapping
    public ResponseEntity<UserProfileEntity> getUserProfile(@AuthenticationPrincipal final UserPrincipal userPrincipal){
        return ResponseEntity.ok(userProfileService.getProfile(userPrincipal.getId()));
    }



}
