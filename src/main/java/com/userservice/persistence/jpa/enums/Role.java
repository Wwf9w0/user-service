package com.userservice.persistence.jpa.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Objects;

@Getter
@AllArgsConstructor
public enum Role {
    ROLE_USER(0),
    ROLE_MODERATOR(1),
    ROLE_ADMIN(2);

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
