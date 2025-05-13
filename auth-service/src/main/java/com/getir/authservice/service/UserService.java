package com.getir.authservice.service;

import com.getir.authservice.dto.RegisterRequest;
import com.getir.authservice.entity.User;

import java.util.Optional;

public interface UserService {
    User register(RegisterRequest request);
    Optional<User> findByEmail(String email);
    Optional<User> findByPhone(String phone);
}
