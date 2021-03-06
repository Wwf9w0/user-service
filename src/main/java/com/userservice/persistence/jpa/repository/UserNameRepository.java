package com.userservice.persistence.jpa.repository;

import com.userservice.persistence.jpa.entity.UserNameEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserNameRepository extends JpaRepository<UserNameEntity, Long> {

    Optional<UserNameEntity> findByUserName(String userName);
}
