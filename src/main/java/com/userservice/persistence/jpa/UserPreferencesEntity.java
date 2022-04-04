package com.userservice.persistence.jpa;

import lombok.Data;
import lombok.RequiredArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Data
@Table(name = "user_preferences")
@Entity
@RequiredArgsConstructor
public class UserPreferencesEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Boolean sharePost;

    private Boolean shareUserProfile;

    private Boolean sharePostInfo;

    private Date createdDate;

    private Date lastModifiedDate;
}
