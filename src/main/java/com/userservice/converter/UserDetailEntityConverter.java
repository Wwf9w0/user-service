package com.userservice.converter;

import com.userservice.model.dto.UserProfileDto;
import com.userservice.persistence.jpa.entity.UserProfileEntity;
import org.springframework.stereotype.Component;

@Component
public class UserDetailEntityConverter {

    public static UserProfileDto toProfileDto(UserProfileEntity userProfile){
        return UserProfileDto.builder()
                .id(userProfile.getId())
                .firstName(userProfile.getFirstName())
                .lastName(userProfile.getLastName())
                .email(userProfile.getEmail())
                .birthDate(userProfile.getBirthDate())
                .gender(userProfile.getGender())
                .profilePhoto(userProfile.getProfilePhoto())
                .createdDate(userProfile.getCreatedDate())
                .lastModifiedDate(userProfile.getLastModifiedDate())
                .build();
    }
}
