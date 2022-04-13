package com.userservice.service;

import com.userservice.persistence.jpa.service.EmailPersistenceService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor
public class EmailService {

    private final EmailPersistenceService emailPersistenceService;

    public void updateEmail(String userName, String requestedEmail){
        emailPersistenceService.updateEmail(userName,requestedEmail);
    }
}
