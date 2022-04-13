package com.userservice.converter;

import com.userservice.model.dto.UserPreferencesDto;
import com.userservice.model.request.UserCreateRequest;
import com.userservice.persistence.jpa.entity.UserPreferencesEntity;
import com.userservice.persistence.jpa.entity.UserProfileEntity;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
@Getter
@RequiredArgsConstructor
public class UserPreferencesEntityConverter {


    public UserPreferencesDto toPreDto(UserPreferencesEntity preferences){
        return UserPreferencesDto.builder()
                .id(preferences.getId())
                .sharePost(preferences.getSharePost())
                .shareUserProfile(preferences.getShareUserProfile())
                .sharePostInfo(preferences.getSharePostInfo())
                .createdDate(preferences.getCreatedDate())
                .lastModifiedDate(preferences.getLastModifiedDate())
                .build();
    }


    public UserPreferencesEntity toEntity(UserPreferencesDto preferencesDto){
        return UserPreferencesEntity.builder()
                .id(preferencesDto.getId())
                .sharePost(preferencesDto.getSharePost())
                .shareUserProfile(preferencesDto.getShareUserProfile())
                .sharePostInfo(preferencesDto.getSharePostInfo())
                .createdDate(preferencesDto.getCreatedDate())
                .lastModifiedDate(preferencesDto.getLastModifiedDate())
                .build();
    }

}
