package com.getir.authservice.repository;

import com.getir.authservice.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface UserRepository extends JpaRepository<User, UUID> {
    Optional<User> findByPhone(String phone);
    boolean existsByPhone(String phone);

    Optional<User> findByEmail(String email);

    boolean existsByEmail(String email);

}