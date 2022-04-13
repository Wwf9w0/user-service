package com.userservice.persistence.jpa.service;

import com.userservice.converter.UserDetailEntityConverter;
import com.userservice.converter.UserProfileEntityConverter;
import com.userservice.model.response.UserDetailResponse;
import com.userservice.persistence.jpa.entity.UserEntity;
import com.userservice.persistence.jpa.entity.UserProfileEntity;
import com.userservice.persistence.jpa.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
@RequiredArgsConstructor
@Slf4j
public class UserProfilePersistenceService {

    private final UserRepository userRepository;
    private final UserProfileEntityConverter userProfileEntityConverter;
    private final UserDetailEntityConverter userDetailEntityConverter;

    public UserDetailResponse getProfile(Long id) {
        UserEntity user = userRepository.findById(id).orElse(null);
        return userProfileEntityConverter.toResponse(user);
    }


    public UserProfileEntity getUserById(Long id){

        UserEntity userEntity = userRepository.findById(id).orElse(null);
        return userEntity.getUserProfile();
    }


    private void updateNickName(String userName,
                                UserEntity user,
                                UserProfileEntity userProfile){
        if (Objects.nonNull(userName) && !Objects.equals(userName, user.getUserName())){

        }
    }
}
