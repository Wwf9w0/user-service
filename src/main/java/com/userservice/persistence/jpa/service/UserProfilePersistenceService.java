package com.userservice.persistence.jpa.service;

import com.userservice.persistence.jpa.repository.UserProfileRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class UserProfilePersistenceService {
    private final UserProfileRepository userProfileRepository;


}
