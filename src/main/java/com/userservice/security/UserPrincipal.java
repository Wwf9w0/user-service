package com.userservice.security;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.userservice.persistence.jpa.UserEntity;
import com.userservice.persistence.jpa.UserStatus;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.Objects;

@Getter
@Setter
@Builder
public class UserPrincipal implements UserDetails {

    private Long id;
    private String name;
    private String lastName;
    private String userName;
    @JsonIgnore
    private String email;

    @JsonIgnore
    private String mobileNUmber;

    private String password;
    private UserStatus userStatus;
    private Integer failedLoginCount;
    private String userIp;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return null;
    }

    public static UserPrincipal constructUserPrinciple(UserEntity user) {
        return UserPrincipal.builder()
                .id(user.getId())
                .name(user.getUserProfile().getFirstName())
                .lastName(user.getUserProfile().getLastName())
                .userName(user.getUserProfile().getNickname())
                .email(user.getUserProfile().getEmail())
                .password(user.getPassword())
                .failedLoginCount(user.getFailingCount())
                .build();
    }

    @Override
    public String getUsername() {
        return userName;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        UserPrincipal u = (UserPrincipal) o;
        return Objects.equals(id, u.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
