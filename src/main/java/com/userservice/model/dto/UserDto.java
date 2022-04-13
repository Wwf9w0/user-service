package com.userservice.model.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UserDto {

    private Long id;
    private String password;
    private String userName;
    private Integer status;
    private String userId;
    private Integer failingCount;
    private Date registerDate;
    private UserPreferencesDto userPreferences;
    private UserProfileDto userProfile;
    private Date createdDate;
    private Date lastModifiedDate;



}
