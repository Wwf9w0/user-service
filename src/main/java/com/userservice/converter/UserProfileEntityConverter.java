package com.userservice.converter;

import com.userservice.model.dto.UserProfileDto;
import com.userservice.model.response.UserDetailResponse;
import com.userservice.persistence.jpa.entity.UserEntity;
import com.userservice.persistence.jpa.entity.UserProfileEntity;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@Getter
@RequiredArgsConstructor
public class UserProfileEntityConverter {
    private final UserDetailEntityConverter userDetailEntityConverter;

    public UserProfileDto toProfileDto(UserProfileEntity userProfile){
        return UserProfileDto.builder()
                .id(userProfile.getId())
                .firstName(userProfile.getFirstName())
                .lastName(userProfile.getLastName())
                .email(userProfile.getEmail())
                .birthDate(userProfile.getBirthDate())
                .gender(userProfile.getGender())
                .profilePhoto(userProfile.getProfilePhoto())
                .isUserNameConfirmed(userProfile.getIsUserNameConfirmed())
                .createdDate(userProfile.getCreatedDate())
                .lastModifiedDate(userProfile.getLastModifiedDate())
                .build();
    }

    public UserDetailResponse toResponse(UserEntity user){
        return UserDetailResponse.builder()
                .profilePhoto(user.getUserProfile().getProfilePhoto())
                .gender(user.getUserProfile().getGender())
                .id(user.getId())
                .userName(user.getUserName())
                .userProfileDto(userDetailEntityConverter.toProfileDto(user.getUserProfile()))
                .build();
    }
}
