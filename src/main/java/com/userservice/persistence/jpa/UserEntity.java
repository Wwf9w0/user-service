package com.userservice.persistence.jpa;

import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Index;
import javax.persistence.Table;
import java.util.Date;

@Getter
@Setter
@Builder
@Entity
@Table(name = "user", indexes = {@Index(name = "IDX_USER_ID", columnList = "id")})
@RequiredArgsConstructor
public class UserEntity {

    @Id
    private Long id;

    private String password;
    private Integer status;
    private Integer failingCount;
    private Date registerDate;
    private UserPreferencesEntity userPreferences;
    private UserProfileEntity userProfile;
    private Date createdDate;
    private Date lastModifiedDate;

}
