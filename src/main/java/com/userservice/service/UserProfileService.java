package com.userservice.service;

import com.userservice.model.UserDetail;
import com.userservice.persistence.jpa.entity.UserProfileEntity;
import com.userservice.persistence.jpa.service.UserProfilePersistenceService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserProfileService {

    private final UserProfilePersistenceService persistenceService;

    public UserDetail getProfile(Long id) {
        return persistenceService.getProfile(id);
    }
}
