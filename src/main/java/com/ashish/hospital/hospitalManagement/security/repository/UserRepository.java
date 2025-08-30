package com.ashish.hospital.hospitalManagement.security.repository;

import com.ashish.hospital.hospitalManagement.security.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByUsername(String username);
}
