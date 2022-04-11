package com.userservice.service;

import com.userservice.persistence.jpa.entity.UserEntity;
import com.userservice.persistence.jpa.entity.UserProfileEntity;
import com.userservice.persistence.jpa.service.UserPersistenceService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.encrypt.Encryptors;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import sun.security.util.Password;

import java.util.Optional;

@RequiredArgsConstructor
@Service
@Slf4j
public class UserService {

    private final UserPersistenceService userPersistenceService;

    public UserEntity save(UserEntity user) {
        BCryptPasswordEncoder password1 = new BCryptPasswordEncoder();
        String p = password1.encode(user.getPassword());
        user.setPassword(p);
        log.info(user.getPassword());
        return userPersistenceService.saveUser(user);
    }



    public Optional<UserProfileEntity> findByUserName(String userName) {
        return userPersistenceService.userget(userName);
    }
}
