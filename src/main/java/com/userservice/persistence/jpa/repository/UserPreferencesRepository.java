package com.userservice.persistence.jpa.repository;

import com.userservice.persistence.jpa.entity.UserPreferencesEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserPreferencesRepository extends JpaRepository<UserPreferencesEntity, Long> {
}
