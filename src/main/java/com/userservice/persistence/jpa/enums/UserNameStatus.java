package com.userservice.persistence.jpa.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum UserNameStatus {
    ACTIVE(0),
    PASSIVE(1);

    private final Integer status;

}
