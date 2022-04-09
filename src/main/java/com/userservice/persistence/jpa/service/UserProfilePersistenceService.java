package com.userservice.persistence.jpa.service;

import com.userservice.model.UserDetail;
import com.userservice.persistence.jpa.converter.UserEntityConverter;
import com.userservice.persistence.jpa.entity.UserEntity;
import com.userservice.persistence.jpa.entity.UserProfileEntity;
import com.userservice.persistence.jpa.repository.UserProfileRepository;
import com.userservice.persistence.jpa.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class UserProfilePersistenceService {

    private final UserRepository userRepository;
    private  final UserEntityConverter converter;

    public UserDetail getProfile(Long id) {
        UserEntity user = userRepository.findById(id).orElse(null);
        UserProfileEntity userProfile = user.getUserProfile();
        return converter.toDtail(userProfile);
    }
}
