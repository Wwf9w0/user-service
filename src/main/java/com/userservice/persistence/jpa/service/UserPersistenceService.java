package com.userservice.persistence.jpa.service;

import com.userservice.persistence.jpa.entity.UserEntity;
import com.userservice.persistence.jpa.entity.UserProfileEntity;
import com.userservice.persistence.jpa.repository.UserProfileRepository;
import com.userservice.persistence.jpa.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Objects;
import java.util.Optional;

@Slf4j
@Service
@RequiredArgsConstructor
public class UserPersistenceService {

    private final UserRepository userRepository;
    private final UserProfileRepository repository;

    @Transactional
    public UserEntity saveUser(UserEntity user) {
        UserProfileEntity userProfile = new UserProfileEntity();
        userProfile.setEmail(user.getUserProfile().getEmail());
        log.info("Save user by nickName : {}", user.getUserName());
        return userRepository.save(user);
    }
}
