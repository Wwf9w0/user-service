package com.userservice.service;

import com.userservice.persistence.jpa.entity.UserNameEntity;
import com.userservice.persistence.jpa.service.UserNamePersistenceService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor
public class UserNameService {
    private final UserNamePersistenceService userNamePersistenceService;

    public void updateUserName(String currentUserName, String requestedUserName){
        userNamePersistenceService.updateNickName(currentUserName,requestedUserName);
    }
}
