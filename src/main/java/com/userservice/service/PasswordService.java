package com.userservice.service;

import com.userservice.persistence.jpa.service.PasswordPersistenceService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class PasswordService {

    private final PasswordPersistenceService passwordPersistenceService;

    public void updatePassword(String userName,
                               String currentPassword,
                               String requestedPassword){
        passwordPersistenceService.updatePassword(
                userName,
                currentPassword,
                requestedPassword
        );
    }
}
