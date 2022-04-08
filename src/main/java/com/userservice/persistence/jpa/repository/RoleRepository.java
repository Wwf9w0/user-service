package com.userservice.persistence.jpa.repository;

import com.userservice.persistence.jpa.entity.RoleEntiy;
import com.userservice.persistence.jpa.enums.Role;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RoleRepository extends JpaRepository<RoleEntiy, Long> {

    Optional<RoleEntiy> findByName(Role name);

}
