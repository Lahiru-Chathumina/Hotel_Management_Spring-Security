package org.example.repostory;

import org.example.entity.CustomerEntity;
import org.example.entity.RoomEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RoomRepostory extends JpaRepository<RoomEntity, Long> {
    Optional<RoomEntity> findAllById(Long roomId);
}
