package org.example.dto;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
public class AuthResponse {
    private String email;
    private String role;
    private String token;
}
