package com.userservice.model.dto;

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
public class UserProfileDto {

    private Long id;
    private String firstName;
    private String lastName;
    private String email;
    private Date birthDate;
    private Integer gender;
    private String profilePhoto;
    private Boolean isUserNameConfirmed;
    private Date createdDate;
    private Date lastModifiedDate;
}
