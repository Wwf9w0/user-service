package com.userservice.converter;

import com.userservice.model.dto.UserDto;
import com.userservice.persistence.jpa.entity.UserEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class UserEntityConverter {
    private final UserPreferencesEntityConverter preferencesConverter;
    private final UserProfileEntityConverter userProfileEntityConverter;

    public UserDto toUserDto(UserEntity user){

        return UserDto.builder()
                .id(user.getId())
                .externalNo(user.getExternalNo())
                .password(user.getPassword())
                .userName(user.getUserName())
                .status(user.getStatus())
                .userId(user.getUserId())
                .failingCount(user.getFailingCount())
                .userPreferences(preferencesConverter.toPreDto(user.getUserPreferences()))
                .userProfile(userProfileEntityConverter.toProfileDto(user.getUserProfile()))
                .createdDate(user.getCreatedDate())
                .lastModifiedDate(user.getLastModifiedDate())
                .build();
    }
}
