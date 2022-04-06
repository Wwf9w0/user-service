package com.userservice.service;

import com.userservice.persistence.jpa.entity.UserEntity;
import com.userservice.persistence.jpa.entity.UserProfileEntity;
import com.userservice.persistence.jpa.service.UserPersistenceService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@RequiredArgsConstructor
@Service
public class UserService {

    private final UserPersistenceService userPersistenceService;


    public UserEntity save(UserEntity user){
        return userPersistenceService.saveUser(user);
    }

    public Optional<UserProfileEntity> findByUserName(String userName){
        return userPersistenceService.userget(userName);
    }


}
