package com.userservice.service;

import com.userservice.persistence.jpa.entity.UserEntity;
import com.userservice.persistence.jpa.enums.AuthType;
import com.userservice.persistence.jpa.repository.UserProfileRepository;
import com.userservice.persistence.jpa.repository.UserRepository;
import com.userservice.security.UserPrincipal;
import lombok.RequiredArgsConstructor;
import org.apache.commons.lang3.math.NumberUtils;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@RequiredArgsConstructor
public class UserDetailService implements UserDetailsService {

    private final UserRepository userRepository;


    @Override
    @Transactional
    public UserDetails loadUserByUsername(String id) throws UsernameNotFoundException {
        UserEntity  user = userRepository.findById(NumberUtils.createLong(id))
                .orElseThrow(() -> new UsernameNotFoundException("User Not Found with userId: " + id));
        return createPrincipal(user);
    }

    @Transactional
    public UserDetails createPrincipal(final UserEntity user){
        final UserPrincipal userPrincipal = UserPrincipal.constructUserPrinciple(user);
        return userPrincipal;
    }

    @Transactional
    public UserPrincipal loadByUserId(final Long id){
        UserEntity user = userRepository.findById(id).orElse(null);
        return UserPrincipal.constructUserPrinciple(user);

    }
}
