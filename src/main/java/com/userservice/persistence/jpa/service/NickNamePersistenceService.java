package com.userservice.persistence.jpa.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
@Slf4j
@RequiredArgsConstructor
public class NickNamePersistenceService {


    void updateNickName(
            Long userId,
            String currentUserName,
            String requestedUserName){
        if (StringUtils.isEmpty(requestedUserName) || Objects.equals(currentUserName, requestedUserName)){
            return;
        }


    }

}
