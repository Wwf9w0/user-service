package com.userservice.model.dto;

import com.userservice.persistence.jpa.entity.UserPreferencesEntity;
import com.userservice.persistence.jpa.entity.UserProfileEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.stereotype.Component;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import java.util.Date;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UserDto {

    private Long id;
    private Long externalNo;
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
