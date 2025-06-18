package org.example.controller;

import lombok.RequiredArgsConstructor;
import org.example.dto.RoomDto;
import org.example.service.RoomService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
    @RequestMapping("/room")
@CrossOrigin
@RequiredArgsConstructor
public class RoomController {

    private final RoomService roomService;

    @PostMapping("/add")
    public void addRoom(@RequestBody RoomDto roomDto){
        roomService.addRoom(roomDto);
    }

    @GetMapping("/all")
    public List<RoomDto> getAllRooms() {
        return roomService.getAllRooms();
    }

    @GetMapping("/{id}")
    public RoomDto getRoomById(@PathVariable Long id) {
        return roomService.getRoomById(id);
    }

    @PutMapping("/update/{id}")
    public void updateRoom(@PathVariable Long id, @RequestBody RoomDto roomDto) {
        roomService.updateRoom(id, roomDto);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteRoom(@PathVariable Long id) {
        roomService.deleteRoom(id);
    }
}
