package com.userservice.security;

import com.userservice.persistence.jpa.entity.UserEntity;
import com.userservice.persistence.jpa.entity.UserProfileEntity;
import com.userservice.persistence.jpa.repository.UserProfileRepository;
import com.userservice.persistence.jpa.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@RequiredArgsConstructor
@Service
public class JwtUserDetailService implements UserDetailsService {

    private final UserRepository userRepository;


    @Override
    @Transactional

    public UserDetails loadUserByUsername(String value) throws UsernameNotFoundException {
        return null;
    }

    private UserDetails createPrincipal(final UserEntity user){
        UserPrincipal userPrincipal = UserPrincipal.constructUserPrinciple(user);
        return userPrincipal;
    }
}
