package com.userservice.persistence.jpa.repository;

import com.userservice.persistence.jpa.entity.RefreshTokenEntity;
import com.userservice.persistence.jpa.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RefreshTokenRepository extends JpaRepository<RefreshTokenEntity, Long> {

    Optional<RefreshTokenEntity> findByToken(String token);
    @Modifying
    int deleteByUser(UserEntity user);
}
