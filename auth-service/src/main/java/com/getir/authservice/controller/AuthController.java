package com.getir.authservice.controller;

import com.getir.authservice.dto.AuthRequest;
import com.getir.authservice.dto.JwtResponse;
import com.getir.authservice.dto.RegisterRequest;
import com.getir.authservice.entity.User;
import com.getir.authservice.service.UserService;
import com.getir.authservice.util.JwtService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {

    private final UserService userService;
    private final JwtService jwtService;
    private final PasswordEncoder passwordEncoder;

    @PostMapping("/register")
    public ResponseEntity<JwtResponse> register(@RequestBody RegisterRequest request) {
        User user = userService.register(request);
        String token = jwtService.generateToken(user);
        return ResponseEntity.ok(new JwtResponse(token, user.getRole()));
    }

    @PostMapping("/login")
    public ResponseEntity<JwtResponse> login(@RequestBody AuthRequest request) {
        User user = userService.findByEmail(request.getEmail())
                .orElseThrow(() -> new RuntimeException("Invalid credentials"));

        if (!passwordEncoder.matches(request.getPassword(), user.getPassword())) {
            throw new RuntimeException("Invalid credentials");
        }

        String token = jwtService.generateToken(user);
        return ResponseEntity.ok(new JwtResponse(token, user.getRole()));
    }
}
