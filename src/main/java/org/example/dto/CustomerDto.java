package org.example.dto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class CustomerDto {
    private Long customerid;
    private String name;
    private String email;
    private String password;

    private String phoneNumber;
    private String address;
    private String role = "CUSTOMER";
}
