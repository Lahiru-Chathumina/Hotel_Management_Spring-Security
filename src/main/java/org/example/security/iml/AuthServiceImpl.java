package org.example.security.iml;

import lombok.AllArgsConstructor;
import org.example.dto.AuthResponse;
import org.example.dto.LoginRequestDto;
import org.example.dto.RegisterRequestDTo;
import org.example.entity.AdminEntity;
import org.example.entity.CustomerEntity;
import org.example.repostory.CustomerRepostory;
import org.example.repostory.adminrepostory;
import org.example.security.AuthService;
import org.example.security.JwtService;
import org.example.util.Role;
import org.modelmapper.ModelMapper;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
public class AuthServiceImpl implements AuthService {

    private final adminrepostory adminRepo;
    private final CustomerRepostory customerRepo;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;
    private final ModelMapper modelMapper;


    @Override
    public String registerAdmin(RegisterRequestDTo registerRequestDTo) {

        AdminEntity admin = modelMapper.map(registerRequestDTo, AdminEntity.class);
        admin.setPassword(passwordEncoder.encode(registerRequestDTo.getPassword()));
        admin.setRole(Role.ADMIN);
        adminRepo.save(admin);
        return "Admin registered successfully";

    }

    @Override
    public String registerCustomer(RegisterRequestDTo registerRequestDTo) {
        CustomerEntity customer = modelMapper.map(registerRequestDTo, CustomerEntity.class);
        customer.setPassword(passwordEncoder.encode(registerRequestDTo.getPassword()));
        customer.setRole(Role.CUSTOMER);
        customerRepo.save(customer);
        return "Customer registered successfully";
    }

    @Override
    public AuthResponse authenticate(LoginRequestDto loginRequestDto) {
        Optional<AdminEntity> admin = adminRepo.findByEmail(loginRequestDto.getEmail());

        if (admin.isPresent()) {
            if (passwordEncoder.matches(loginRequestDto.getPassword(), admin.get().getPassword())) {

                UserDetails userDetails = User.builder()
                        .username(admin.get().getEmail())
                        .password(admin.get().getPassword())
                        .authorities("ROLE_ADMIN")
                        .build();

                String token = jwtService.generateToken(userDetails);

                return AuthResponse.builder()
                        .email(admin.get().getEmail())
                        .role(admin.get().getRole().name())
                        .token(token)
                        .build();
            }
        }

        Optional<CustomerEntity> customer = customerRepo.findByEmail(loginRequestDto.getEmail());
        if (customer != null) {
            if (passwordEncoder.matches(loginRequestDto.getPassword(), customer.get().getPassword())) {

                UserDetails userDetails = User.builder()
                        .username(customer.get().getEmail())
                        .password(customer.get().getPassword())
                        .authorities("ROLE_CUSTOMER")
                        .build();

                String token = jwtService.generateToken(userDetails);

                return AuthResponse.builder()
                        .email(customer.get().getEmail())
                        .role(customer.get().getRole().name())
                        .token(token)
                        .build();
            }
        }

        throw new RuntimeException("Invalid email or password");
    }
}
