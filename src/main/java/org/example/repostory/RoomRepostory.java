package org.example.repostory;

import org.example.entity.RoomEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoomRepostory extends JpaRepository<RoomEntity, Long> {
}
