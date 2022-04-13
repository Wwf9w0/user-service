package com.userservice.converter;

import com.userservice.model.dto.UserPreferencesDto;
import com.userservice.persistence.jpa.entity.UserPreferencesEntity;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

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
}
