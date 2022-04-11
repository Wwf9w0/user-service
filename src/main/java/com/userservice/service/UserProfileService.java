package com.userservice.service;

import com.userservice.persistence.jpa.entity.UserEntity;
import com.userservice.persistence.jpa.entity.UserProfileEntity;
import com.userservice.persistence.jpa.service.UserProfilePersistenceService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserProfileService {

    private final UserProfilePersistenceService userProfilePersistenceService;

    public UserProfileEntity getProfile(Long id) {
        return userProfilePersistenceService.getProfile(id);
    }

    public UserProfileEntity getUserById(Long id){
        return userProfilePersistenceService.getUserById(id);
    }
}
