package com.userservice.persistence.jpa.service;

import com.userservice.converter.UserEntityConverter;
import com.userservice.model.dto.UserDto;
import com.userservice.model.dto.UserPreferencesDto;
import com.userservice.model.dto.UserProfileDto;
import com.userservice.model.request.UserCreateRequest;
import com.userservice.persistence.jpa.entity.UserEntity;
import com.userservice.persistence.jpa.entity.UserProfileEntity;
import com.userservice.persistence.jpa.repository.UserProfileRepository;
import com.userservice.persistence.jpa.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Objects;
import java.util.Optional;

@Slf4j
@Service
@RequiredArgsConstructor
public class UserPersistenceService {

    private final UserRepository userRepository;
    private final UserEntityConverter userEntityConverter;


    @Transactional
    public UserDto savedUser(UserCreateRequest request){
        final UserEntity user = userEntityConverter.toUserEntity(request);
        String pass = userPasswordEncode(request.getPassword());
        user.setPassword(pass);
        UserEntity savedUser = userRepository.save(user);
        return userEntityConverter.toUserDto(savedUser);
    }


    public UserEntity getUserByUserName(String userName){
        return userRepository.findByUserName(userName).orElse(null);
    }

    private String userPasswordEncode(String password){
        BCryptPasswordEncoder pw = new BCryptPasswordEncoder();
        String encodePassword = pw.encode(password);
        return encodePassword;
    }
}
