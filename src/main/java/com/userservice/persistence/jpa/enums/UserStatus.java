package com.userservice.persistence.jpa.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Objects;

@Getter
@AllArgsConstructor
public enum UserStatus {
    ACTIVE(1),
    PASSIVE_USER(2),
    BLOCKED(-1);

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
