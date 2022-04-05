package com.userservice.persistence.jpa.repository;

import com.userservice.persistence.jpa.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;


@Repository
public interface UserRepository extends JpaRepository<UserEntity , Long> {

    UserEntity findByUserID(String userId);
}
