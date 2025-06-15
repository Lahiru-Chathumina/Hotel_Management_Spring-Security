package org.example.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.example.util.Role;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "admin")
public class AdminEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long adminId;
    private String adminName;
    private String email;
    private String password;

    @Enumerated(EnumType.STRING)
    private Role role = Role.ADMIN;
}
