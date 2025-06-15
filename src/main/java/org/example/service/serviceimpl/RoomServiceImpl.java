package org.example.service.serviceimpl;

import lombok.RequiredArgsConstructor;
import org.example.dto.RoomDto;
import org.example.entity.RoomEntity;
import org.example.repostory.RoomRepostory;
import org.example.service.RoomService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class RoomServiceImpl implements RoomService {

    private final RoomRepostory roomRepostory;
    private final ModelMapper modelMapper;

    @Override
    public void addRoom(RoomDto roomDto) {
        roomRepostory.save(modelMapper.map(roomDto, RoomEntity.class));
    }

    @Override
    public List<RoomDto> getAllRooms() {
        List<RoomEntity> rooms = roomRepostory.findAll();
        List<RoomDto> roomDtoList = new ArrayList<>();

        for (RoomEntity room : rooms) {
            roomDtoList.add(modelMapper.map(room, RoomDto.class));
        }
        return roomDtoList;
    }

    @Override
    public RoomDto getRoomById(Long roomId) {
        return roomRepostory.findById(roomId)
                .map(room -> modelMapper.map(room, RoomDto.class))
                .orElse(null);
    }

    @Override
    public void updateRoom(Long roomId, RoomDto roomDto) {
        if(roomRepostory.existsById(roomId)) {
            roomDto.setRoomId(roomId);
            roomRepostory.save(modelMapper.map(roomDto, RoomEntity.class));
        }
    }

    @Override
    public void deleteRoom(Long roomId) {
        roomRepostory.deleteById(roomId);
    }
}
