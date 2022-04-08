package com.userservice.security;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.userservice.persistence.jpa.entity.UserEntity;
import com.userservice.persistence.jpa.enums.UserStatus;
import lombok.Builder;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.Collections;
import java.util.Objects;

@Data
@Builder
public class UserPrincipal implements UserDetails {
    private static final long serialVersionUID = 1L;

    private Long id;
    private String name;
    private String lastName;
    private String userName;
    @JsonIgnore
    private String email;
    @JsonIgnore
    private String mobileNUmber;
    @JsonIgnore
    private String password;
    private UserStatus userStatus;
    private Integer failedLoginCount;
    private String userIp;
    private Collection<? extends GrantedAuthority> authorities;


    public static UserPrincipal constructUserPrinciple(UserEntity user) {
        return UserPrincipal.builder()
                .id(user.getId())
                .name(user.getUserProfile().getFirstName())
                .lastName(user.getUserProfile().getLastName())
                .userName(user.getUserProfile().getNickName())
                .email(user.getUserProfile().getEmail())
                .password(user.getPassword())
                .failedLoginCount(user.getFailingCount())
                .authorities(Collections.emptyList())
                .build();
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return userName;
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
