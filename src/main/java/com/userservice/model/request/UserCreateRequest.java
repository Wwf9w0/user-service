package com.userservice.model.request;


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
public class UserCreateRequest {
    private String email;
    private String password;
    private String userName;
    private String firstName;
    private String lastName;
    private Integer gender;
}
