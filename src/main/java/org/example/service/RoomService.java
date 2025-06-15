package org.example.service;

import org.example.dto.RoomDto;

import java.util.List;

public interface RoomService {
    void addRoom(RoomDto roomDto);
    List<RoomDto> getAllRooms();
    RoomDto getRoomById(Long roomId);
    void updateRoom(Long roomId, RoomDto roomDto);
    void deleteRoom(Long roomId);
}
