package com.userservice.persistence.jpa.service;

import com.userservice.persistence.jpa.entity.UserEntity;
import com.userservice.persistence.jpa.entity.UserProfileEntity;
import com.userservice.persistence.jpa.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class UserProfilePersistenceService {

    private final UserRepository userRepository;

    public UserProfileEntity getProfile(Long id) {
        UserEntity user = userRepository.findById(id).orElse(null);
        assert user != null;
        return user.getUserProfile();
    }


    public UserProfileEntity getUserById(Long id){

        UserEntity userEntity = userRepository.findById(id).orElse(null);
        assert userEntity != null;
        return userEntity.getUserProfile();
    }
}
