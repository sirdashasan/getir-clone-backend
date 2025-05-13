package com.getir.authservice.config;

import com.getir.authservice.entity.Role;
import com.getir.authservice.entity.User;
import com.getir.authservice.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class DataInitializer implements CommandLineRunner {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    @Override
    public void run(String... args) {
        if (userRepository.findByEmail("admin@getir.com").isEmpty()) {
            User admin = User.builder()
                    .name("Admin")
                    .email("admin@getir.com")
                    .phone("5551234567")
                    .password(passwordEncoder.encode("123456"))
                    .role(Role.ROLE_ADMIN)
                    .build();

            userRepository.save(admin);
        }
    }
}
