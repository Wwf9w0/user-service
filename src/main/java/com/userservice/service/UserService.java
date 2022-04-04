package com.userservice.service;

import com.userservice.persistence.jpa.entity.UserEntity;
import com.userservice.persistence.jpa.service.UserPersistenceService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class UserService {

    private final UserPersistenceService userPersistenceService;


    public UserEntity save(UserEntity user){
        return userPersistenceService.saveUser(user);
    }
}
