package org.example.service.serviceimpl;

import lombok.AllArgsConstructor;
import org.example.dto.BookigDto;
import org.example.entity.BookingEntity;
import org.example.entity.CustomerEntity;
import org.example.entity.RoomEntity;
import org.example.repostory.BookingRepository;
import org.example.repostory.CustomerRepostory;
import org.example.repostory.RoomRepostory;
import org.example.service.BookingService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class BookingServiceImpl implements BookingService {
    private final BookingRepository bookingRepository;
    private final CustomerRepostory customerRepostory;
    private final RoomRepostory roomRepostory;
    private final ModelMapper modelMapper;

    @Override
    public void addBooking(BookigDto bookingDto) {
        Optional<CustomerEntity> allByCustomerId = customerRepostory.findByCustomerid(
                bookingDto.getCustomer().getCustomerid());
        Optional<RoomEntity> allByRoomId1 = roomRepostory.findById(bookingDto.getRoom().getRoomId());

        if(allByCustomerId.isEmpty()) {
            throw new RuntimeException("Customer not found");
        }
        if (allByRoomId1.isEmpty()){
            throw new RuntimeException("Room not found");
        }
        if(!allByRoomId1.get().isAvailable()){
            throw new RuntimeException("Room is not available");
        }
            RoomEntity BookingRooms = allByRoomId1.get();
            BookingRooms.setAvailable(false);
            roomRepostory.save(BookingRooms);


    }

    @Override
    public List<BookigDto> getAllBookings() {
        ArrayList<BookigDto> objectslist = new ArrayList<>();
        List<BookingEntity> all = bookingRepository.findAll();

        all.forEach(BoookingEntity->{
            objectslist.add(modelMapper.map(BoookingEntity,BookigDto.class));
        });
        return objectslist;
    }

    @Override
    public BookigDto getBookingById(Long id) {
        return modelMapper.map(bookingRepository.findById(id), BookigDto.class);
    }

    @Override
    public void updateBooking(Long id, BookigDto bookingDto) {
        bookingRepository.save(modelMapper.map(bookingDto, BookingEntity.class));
    }

    @Override
    public void deleteBooking(Long id) {
      bookingRepository.deleteById(id);
    }
}
