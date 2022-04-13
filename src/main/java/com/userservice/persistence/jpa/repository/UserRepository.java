package com.userservice.persistence.jpa.repository;

import com.userservice.persistence.jpa.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;


public interface UserRepository extends JpaRepository<UserEntity , Long> {

    Optional<UserEntity> findByUserName(String userName);
    Optional<UserEntity> findByExternalNo(Long externalNo);
}
