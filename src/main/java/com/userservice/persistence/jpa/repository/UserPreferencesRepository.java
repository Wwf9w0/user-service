package com.userservice.persistence.jpa.repository;

import com.userservice.persistence.jpa.entity.UserPreferencesEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

public interface UserPreferencesRepository extends JpaRepository<UserPreferencesEntity, Long> {
}
