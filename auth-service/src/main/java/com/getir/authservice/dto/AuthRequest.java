package com.getir.authservice.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AuthRequest {

    @NotBlank(message = "Phone number cannot be blank")
    @Pattern(
            regexp = "^\\d{10}$",
            message = "Invalid phone number. Please enter a 10-digit number, e.g. 5541234567"
    )
    private String phone;

    @NotBlank(message = "Password cannot be blank")
    private String password;
}