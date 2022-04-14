package com.userservice.converter;

import com.userservice.persistence.jpa.entity.UserNameEntity;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;


@Component
@Getter
@RequiredArgsConstructor
public class UserNameEntityConverter {

    public static UserNameEntity requestToEntity (String request){
        return UserNameEntity.builder()
                .userName(request)
                .build();
    }
}
