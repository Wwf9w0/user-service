package com.userservice.persistence.jpa.converter;

import com.userservice.model.UserDetail;
import com.userservice.persistence.jpa.entity.UserEntity;
import com.userservice.persistence.jpa.entity.UserProfileEntity;
import sun.plugin.util.UserProfile;

public class UserEntityConverter {

    public UserDetail toDtail(UserProfileEntity userEntity){
        return UserDetail.builder()
                .userName(userEntity.getUserName())
                .lastName(userEntity.getLastName())
                .name(userEntity.getFirstName())
                .profilePhoto(userEntity.getProfilePhoto())
                .build();
    }
}
