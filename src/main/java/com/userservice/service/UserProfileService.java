package com.userservice.service;

import com.userservice.converter.UserProfileEntityConverter;
import com.userservice.model.dto.UserDto;
import com.userservice.model.dto.UserProfileDto;
import com.userservice.model.response.UserDetailResponse;
import com.userservice.persistence.jpa.entity.UserProfileEntity;
import com.userservice.persistence.jpa.service.UserProfilePersistenceService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserProfileService {

    private final UserProfilePersistenceService userProfilePersistenceService;
    private final UserProfileEntityConverter userProfileEntityConverter;

    public UserDetailResponse getProfile(Long id) {
        return userProfilePersistenceService.getProfile(id);
    }

    public UserProfileEntity getUserById(Long id){
        return userProfilePersistenceService.getUserById(id);
    }

    public UserProfileDto getProfileByUserName(String userName){
        UserProfileEntity userProfile = userProfilePersistenceService.getProfileByUserName(userName);
        return userProfileEntityConverter
                .toProfileDto(userProfile);
    }
}

