package org.example.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.example.util.Role;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
@Table(name = "Customer")
public class CustomerEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long customerid;
    private String name;
    private String email;
    private String password;

    private String phoneNumber;
    private String address;

    @Enumerated(EnumType.STRING)
    private Role role = Role.CUSTOMER;
}
