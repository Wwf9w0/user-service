package com.userservice.persistence.jpa.repository;

import com.userservice.persistence.jpa.entity.Token;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TokenRepository extends JpaRepository<Token, String> {
}
