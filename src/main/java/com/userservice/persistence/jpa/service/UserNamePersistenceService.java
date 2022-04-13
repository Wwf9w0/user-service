package com.userservice.persistence.jpa.service;

import com.userservice.persistence.jpa.entity.UserEntity;
import com.userservice.persistence.jpa.entity.UserNameEntity;
import com.userservice.persistence.jpa.repository.UserNameRepository;
import com.userservice.persistence.jpa.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import java.util.Objects;
import java.util.Optional;

@Service
@Slf4j
@RequiredArgsConstructor
public class UserNamePersistenceService {

    private final UserNameRepository userNameRepository;
    private final UserRepository userRepository;


    public void updateNickName(
            String currentUserName,
            String requestedUserName){
        if (StringUtils.isEmpty(requestedUserName) || Objects.equals(currentUserName, requestedUserName)){
            return;
        }
        assertUserName(requestedUserName, currentUserName);

    }

    private void assertUserName(String requestedUserName, String currentName){
        Optional<UserNameEntity> userNameEntity = Optional.ofNullable(userNameRepository.findByUserName(requestedUserName));
        if (userNameEntity.isPresent()){
            //TODO add assert exception
            throw new RuntimeException();
        }
        Optional<UserEntity> user = userRepository.findByUserName(currentName);
        user.get().setUserName(requestedUserName);
        user.get().getUserNameEntity().setUserName(requestedUserName);
        userNameRepository.save(userNameEntity.get());
        userRepository.save(user.get());
    }
}
