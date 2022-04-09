package com.userservice.persistence.jpa.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Objects;

@AllArgsConstructor
@Getter
public enum AuthType {
    ID(0),
    IDENTITY_ID(1);

    private final Integer status;

    public static UserStatus value(final int status) {
        for (UserStatus userStatus : UserStatus.values()) {
            if (Objects.equals(userStatus.getStatus(), status)) {
                return userStatus;
            }
        }
        throw new RuntimeException("Unknown user status for value : {}" + status);
    }
}