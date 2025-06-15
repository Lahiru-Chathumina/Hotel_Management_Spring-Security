package org.example.service;

import org.example.dto.BookigDto;

import java.util.List;

public interface BookingService {
    void addBooking(BookigDto bookingDto);

    List<BookigDto> getAllBookings();

    BookigDto getBookingById(Long id);

    void updateBooking(Long id, BookigDto bookingDto);

    void deleteBooking(Long id);
}
