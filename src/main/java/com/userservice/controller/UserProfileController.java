package com.userservice.controller;

import com.userservice.model.dto.UserDto;
import com.userservice.model.dto.UserProfileDto;
import com.userservice.model.response.UserDetailResponse;
import com.userservice.persistence.jpa.entity.UserProfileEntity;
import com.userservice.security.UserPrincipal;
import com.userservice.service.UserProfileService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
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
    public ResponseEntity<UserProfileDto> getUserById(@PathVariable Long id){
        return ResponseEntity.ok(userProfileService.getUserById(id));
    }

    @PostMapping("/update")
    public ResponseEntity<Void> updateUserName(
            @AuthenticationPrincipal final UserPrincipal userPrincipal,
            @RequestParam(value = "userName") String requestedUserName){
        userProfileService.updateUserName(requestedUserName, userPrincipal.getUsername());
        //TODO dewamke
        return new ResponseEntity< >(HttpStatus.OK);
    }
}
