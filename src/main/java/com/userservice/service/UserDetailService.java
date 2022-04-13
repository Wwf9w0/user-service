package com.userservice.service;

import com.userservice.persistence.jpa.entity.UserEntity;
import com.userservice.persistence.jpa.repository.UserRepository;
import com.userservice.security.UserPrincipal;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@RequiredArgsConstructor
@Configuration
public class UserDetailService implements UserDetailsService {

    private final UserRepository userRepository;

    @Override
    @Transactional
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
        UserEntity user = userRepository.findByUserName(userName)
                .orElseThrow(() -> new UsernameNotFoundException("User Not Found with userName: " + userName));
        return createPrincipal(user);
    }

    @Transactional
    public UserDetails createPrincipal(final UserEntity user) {
        return UserPrincipal.constructUserPrinciple(user);
    }

    @Transactional
    public UserPrincipal loadByUserId(final Long id) {
        UserEntity user = userRepository.findById(id).orElse(null);
        assert user != null;
        return UserPrincipal.constructUserPrinciple(user);
    }
}
