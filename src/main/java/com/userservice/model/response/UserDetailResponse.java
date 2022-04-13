package com.userservice.model.response;


import com.userservice.model.dto.UserProfileDto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UserDetailResponse {
    private Long id;
    private String userName;
    private Integer gender;
    private String profilePhoto;
    private UserProfileDto userProfileDto;
}
