package com.userservice.persistence.jpa.service;

import com.userservice.persistence.jpa.entity.UserEntity;
import com.userservice.persistence.jpa.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
@RequiredArgsConstructor
@Slf4j
public class EmailPersistenceService {

    private final UserRepository userRepository;
    private final UserPersistenceService userPersistenceService;


    public void updateEmail(String userName, String requestedEmail){
        if (StringUtils.isEmpty(requestedEmail)){
            return;
        }
        assertEmail(userName, requestedEmail);
    }



    private void assertEmail(String userName, String requestedEmail){
        UserEntity user = userPersistenceService.getUserByUserName(userName);
        if (Objects.equals(user.getUserProfile().getEmail(), requestedEmail)){
            throw  new RuntimeException();
        }
        saveEmail(requestedEmail, userName);
    }


    private void saveEmail(String requestedEmail,
                           String userName) {
        UserEntity user = userPersistenceService.getUserByUserName(userName);
        user.getUserProfile().setEmail(requestedEmail);
        userRepository.save(user);
    }





}
