package com.userservice.persistence.jpa.service;

import com.userservice.converter.UserEntityConverter;
import com.userservice.model.dto.UserDto;
import com.userservice.model.request.UserCreateRequest;
import com.userservice.persistence.jpa.entity.UserEntity;
import com.userservice.persistence.jpa.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Objects;

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

    public List<UserEntity> getAllUser(){
        return userRepository.findAll();
    }

    public UserEntity getUserById(Long id){
        return Objects.requireNonNull(userRepository.findById(id).orElse(null));
    }

    private String userPasswordEncode(String password){
        BCryptPasswordEncoder pw = new BCryptPasswordEncoder();
        return pw.encode(password);
    }
}
