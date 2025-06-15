package org.example.repostory;

import org.example.entity.CustomerEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CustomerRepostory extends JpaRepository <CustomerEntity,Long> {
    Optional<CustomerEntity> findByEmail(String email);

    Optional<CustomerEntity> findAllById(Long customerid);
}
