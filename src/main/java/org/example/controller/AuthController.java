package org.example.controller;

import lombok.RequiredArgsConstructor;
import org.example.dto.AuthResponse;
import org.example.dto.LoginRequestDto;
import org.example.dto.RegisterRequestDTo;
import org.example.security.AuthService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
@CrossOrigin
@RequiredArgsConstructor
public class AuthController {

    private final AuthService authService;

    @PostMapping("/register/admin")
    public ResponseEntity<String> registerAdmin(@RequestBody RegisterRequestDTo registerRequestDTo) {
        return ResponseEntity.ok(authService.registerAdmin(registerRequestDTo));
    }

    @PostMapping("/register/customer")
    public ResponseEntity<String> registerCustomer(@RequestBody RegisterRequestDTo registerRequestDTo) {
        return ResponseEntity.ok(authService.registerCustomer(registerRequestDTo));
    }

    @PostMapping("/login")
    public ResponseEntity<AuthResponse> login(@RequestBody LoginRequestDto loginRequestDto) {
        return ResponseEntity.ok(authService.authenticate(loginRequestDto));
    }
}
