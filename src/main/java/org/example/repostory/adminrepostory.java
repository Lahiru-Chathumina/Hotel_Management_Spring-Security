package org.example.repostory;

import org.example.entity.AdminEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface adminrepostory extends JpaRepository<AdminEntity,Long> {

    Optional<AdminEntity> findByEmail(String email);

}
