package org.example.dto;

import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.example.util.Role;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class AdminDto {
    private Long adminId;
    private String adminName;
    private String email;
    private String password;


}
