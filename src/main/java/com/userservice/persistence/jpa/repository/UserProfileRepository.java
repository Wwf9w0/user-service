package com.userservice.persistence.jpa.repository;

import com.userservice.persistence.jpa.entity.UserProfileEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserProfileRepository extends JpaRepository<UserProfileEntity, Long> {
}
