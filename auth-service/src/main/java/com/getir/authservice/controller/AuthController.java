package com.getir.authservice.controller;

import com.getir.authservice.dto.AuthRequest;
import com.getir.authservice.dto.JwtResponse;
import com.getir.authservice.dto.RegisterRequest;
import com.getir.authservice.entity.User;
import com.getir.authservice.exceptions.ApiException;
import com.getir.authservice.security.JwtService;
import com.getir.authservice.service.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
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
    public ResponseEntity<JwtResponse> register(@RequestBody @Valid RegisterRequest request) {
        User user = userService.register(request);
        String token = jwtService.generateToken(user);
        return ResponseEntity.ok(new JwtResponse(token, user.getRole()));
    }

    @PostMapping("/login")
    public ResponseEntity<JwtResponse> login(@RequestBody @Valid AuthRequest request) {
        User user = userService.findByPhone(request.getPhone())
                .orElseThrow(() -> new ApiException("Invalid credentials", HttpStatus.UNAUTHORIZED));

        if (!passwordEncoder.matches(request.getPassword(), user.getPassword())) {
            throw new ApiException("Invalid credentials", HttpStatus.UNAUTHORIZED);
        }

        String token = jwtService.generateToken(user);
        return ResponseEntity.ok(new JwtResponse(token, user.getRole()));
    }
}
