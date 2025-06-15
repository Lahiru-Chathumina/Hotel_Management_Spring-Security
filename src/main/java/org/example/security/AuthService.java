package org.example.security;

import org.example.dto.AuthResponse;
import org.example.dto.LoginRequestDto;
import org.example.dto.RegisterRequestDTo;

public interface AuthService {
    String registerAdmin(RegisterRequestDTo registerRequestDTo);

    String registerCustomer(RegisterRequestDTo registerRequestDTo);

    AuthResponse authenticate(LoginRequestDto loginRequestDto);
}
