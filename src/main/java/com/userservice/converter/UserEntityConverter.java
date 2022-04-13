package com.userservice.converter;

import com.userservice.model.dto.UserDto;
import com.userservice.model.request.UserCreateRequest;
import com.userservice.persistence.jpa.entity.UserEntity;
import com.userservice.persistence.jpa.enums.UserStatus;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class UserEntityConverter {
    private final UserPreferencesEntityConverter preferencesConverter;
    private final UserProfileEntityConverter userProfileEntityConverter;

    public UserDto toUserDto(UserEntity user){

        return UserDto.builder()
                .id(user.getId())
                .password(user.getPassword())
                .userName(user.getUserName())
                .status(user.getStatus())
                .userId(user.getUserId())
                .failingCount(user.getFailingCount())
               // .userPreferences(preferencesConverter.toPreDto(user.getUserPreferences()))
                .userProfile(userProfileEntityConverter.toProfileDto(user.getUserProfile()))
                .createdDate(user.getCreatedDate())
                .lastModifiedDate(user.getLastModifiedDate())
                .build();
    }

    public List<UserDto> toUserDtoList(List<UserEntity> userEntities){
        return userEntities.stream()
                .map(this::toUserDto)
                .collect(Collectors.toList());
    }


    public UserEntity toUserEntity(UserCreateRequest request){
        return UserEntity.builder()
                .userName(request.getUserName())
                .password(request.getPassword())
                .status(UserStatus.ACTIVE.getStatus())
                .userProfile(userProfileEntityConverter.requestToEntity(request))
                .build();

    }
}
