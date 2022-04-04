package com.userservice.persistence.jpa.repository;

import com.userservice.persistence.jpa.entity.UserProfileEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserProfileRepository extends JpaRepository<UserProfileEntity, Long> {
    Optional<UserProfileEntity> findByNickName(String username);


}
