package com.userservice.service;

import com.userservice.converter.UserEntityConverter;
import com.userservice.model.dto.UserDto;
import com.userservice.model.dto.UserPreferencesDto;
import com.userservice.model.dto.UserProfileDto;
import com.userservice.model.request.UserCreateRequest;
import com.userservice.persistence.jpa.service.UserPersistenceService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;


@RequiredArgsConstructor
@Service
@Slf4j
public class UserService {

    private final UserPersistenceService userPersistenceService;
    private final UserProfileService userProfileService;
    private final UserEntityConverter userEntityConverter;
    private final UserPreferencesService userPreferencesService;

    public UserDto saveUser(UserCreateRequest request){
        return userPersistenceService.savedUser(request);
    }

    public List<UserDto> getAllUser(){
        return userEntityConverter
                .toUserDtoList(userPersistenceService.getAllUser());
    }

    public UserDto getUserById(Long id){
        return userEntityConverter.toUserDto(userPersistenceService.getUserById(id));
    }

    private UserPreferencesDto getPreferencesUserName(String userName){
        return userPreferencesService.getPreferencesByUserName(userName);
    }

    private UserProfileDto getProfileByUserName(String userName){
        return userProfileService.getProfileByUserName(userName);
    }

}
