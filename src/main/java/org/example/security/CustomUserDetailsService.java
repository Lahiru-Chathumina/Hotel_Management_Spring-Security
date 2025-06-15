package org.example.security;

import lombok.RequiredArgsConstructor;
import org.example.entity.AdminEntity;
import org.example.entity.CustomerEntity;
import org.example.repostory.CustomerRepostory;
import org.example.repostory.adminrepostory;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CustomUserDetailsService implements UserDetailsService {

    private final adminrepostory adminrepostory;
    private final CustomerRepostory customerRepostory;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {

        Optional<AdminEntity> admin = adminrepostory.findByEmail(email);
        if (admin.isPresent()) {
            return new User(
                    admin.get().getEmail(),
                    admin.get().getPassword(),
                    List.of(new SimpleGrantedAuthority("ROLE_ADMIN"))
            );
        }

        Optional<CustomerEntity> customer = customerRepostory.findByEmail(email);
        if (customer.isPresent()) {
            return new User(
                    customer.get().getEmail(),
                    customer.get().getPassword(),
                    List.of(new SimpleGrantedAuthority("ROLE_CUSTOMER"))
            );
        }

        throw new UsernameNotFoundException("User not found with email: " + email);
    }
}
