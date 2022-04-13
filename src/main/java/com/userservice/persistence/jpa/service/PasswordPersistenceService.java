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
public class PasswordPersistenceService {

    private final UserPersistenceService userPersistenceService;
    private final UserRepository userRepository;



    public void updatePassword(String userName,
                               String currentPassword,
                               String requestedPassword){
        if (StringUtils.isEmpty(requestedPassword) ||
                StringUtils.isEmpty(currentPassword) ||
                StringUtils.isEmpty(userName)){
           return;
        }
        savePassword(userName, currentPassword, requestedPassword);
    }


    private void savePassword(String userName,
                              String currentPassword,
                              String requestedPassword){
        UserEntity user = userPersistenceService.getUserByUserName(userName);
      //  String currentPwCrypted = userPersistenceService.userPasswordEncode(currentPassword);
        if (Objects.nonNull(currentPassword)){
            String pw = userPersistenceService.userPasswordEncode(requestedPassword);
            user.setPassword(pw);
            userRepository.save(user);
        }else {
            throw new RuntimeException();
        }
    }


}
