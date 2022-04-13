package com.userservice.controller;

import com.userservice.model.response.UserDetailResponse;
import com.userservice.persistence.jpa.entity.UserProfileEntity;
import com.userservice.security.UserPrincipal;
import com.userservice.service.UserProfileService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RequiredArgsConstructor
@RestController
@RequestMapping("/user-profile")
public class UserProfileController {

    //TODO updateUserDetail - updateusername-update pp..
    //TODO default pp
    // TODO upload

    private final UserProfileService userProfileService;

    @GetMapping
    public ResponseEntity<UserDetailResponse> getUserProfile(@AuthenticationPrincipal final UserPrincipal userPrincipal){
        return ResponseEntity.ok(userProfileService.getProfile(userPrincipal.getId()));
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserProfileEntity> getUserById(@PathVariable Long id){
        return ResponseEntity.ok(userProfileService.getUserById(id));
    }

}
