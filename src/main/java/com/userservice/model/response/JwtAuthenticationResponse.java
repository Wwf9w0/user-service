package com.userservice.model.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class JwtAuthenticationResponse {

        private String accessToken;
        private String refreshToken;
        private String tokenType;
        private boolean reactivated;
        private List<String> roles;

}
