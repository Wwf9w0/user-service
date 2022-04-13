package com.userservice.persistence.jpa.service;

import com.userservice.persistence.jpa.entity.UserEntity;
import com.userservice.persistence.jpa.entity.UserPreferencesEntity;
import com.userservice.persistence.jpa.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class UserPreferencesPersistenceService {

    private final UserRepository userRepository;

    public UserPreferencesEntity getUserPreferencesByUserName(String userName) {
        UserEntity user = userRepository.findByUserName(userName).orElse(null);
        return user.getUserPreferences();
    }
}
