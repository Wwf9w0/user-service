package com.userservice.persistence.jpa.service;

import com.userservice.converter.UserProfileEntityConverter;
import com.userservice.model.response.UserDetailResponse;
import com.userservice.persistence.jpa.entity.UserEntity;
import com.userservice.persistence.jpa.entity.UserProfileEntity;
import com.userservice.persistence.jpa.repository.UserRepository;
import com.userservice.service.EmailService;
import com.userservice.service.UserNameService;
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
    private final UserNameService userNameService;
    private final EmailService emailService;

    public UserDetailResponse getProfile(Long id) {
        UserEntity user = userRepository.findById(id).orElse(null);
        return userProfileEntityConverter.toResponse(user);
    }

    public UserProfileEntity getUserById(Long id) {
        UserEntity userEntity = userRepository.findById(id).orElse(null);
        return Objects.requireNonNull(userEntity).getUserProfile();
    }

    public UserProfileEntity getProfileByUserName(String userName) {
        UserEntity user = userRepository.findByUserName(userName).orElse(null);
        return user.getUserProfile();
    }

    public void updateNickName(String requestedUserName,
                               String currentUserName) {
        if (!Objects.nonNull(requestedUserName) && !Objects.equals(requestedUserName, currentUserName)) {
            //TODO added exception handle
            throw new RuntimeException();
        }
        userNameService.updateUserName(currentUserName, requestedUserName);
    }

    public void updateEmail(String userName,
                            String requestedEmail){
        if (!Objects.nonNull(requestedEmail)){
            throw new RuntimeException();
        }
        emailService.updateEmail(userName,requestedEmail);
    }
}
