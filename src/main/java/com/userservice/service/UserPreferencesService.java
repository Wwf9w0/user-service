package com.userservice.service;

import com.userservice.converter.UserPreferencesEntityConverter;
import com.userservice.model.dto.UserPreferencesDto;
import com.userservice.persistence.jpa.entity.UserPreferencesEntity;
import com.userservice.persistence.jpa.service.UserPreferencesPersistenceService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
@Slf4j
public class UserPreferencesService {
    private final UserPreferencesPersistenceService userPreferencesPersistenceService;
    private final UserPreferencesEntityConverter userPreferencesEntityConverter;


    public UserPreferencesDto getPreferencesByUserName(String userName) {

        UserPreferencesEntity userPreferences = userPreferencesPersistenceService
                .getUserPreferencesByUserName(userName);
        return userPreferencesEntityConverter.toPreDto(userPreferences);
    }
}
