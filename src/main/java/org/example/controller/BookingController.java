package org.example.controller;

import lombok.RequiredArgsConstructor;
import org.example.dto.BookigDto;
import org.example.service.BookingService;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/booking")
@RequiredArgsConstructor
public class BookingController {

    private final BookingService bookingService;

    @PostMapping("/add")
    @PreAuthorize("hasRole('CUSTOMER') or hasRole('ADMIN')")
    public void add(@RequestBody BookigDto bookingDto) {
        bookingService.addBooking(bookingDto);
    }

    @GetMapping("/all")
    @PreAuthorize("hasRole('ADMIN')")
    public List<BookigDto> getAllBookings() {
        return bookingService.getAllBookings();
    }

    @GetMapping("/{id}")
    public BookigDto getBookingById(@PathVariable Long id) {
        return bookingService.getBookingById(id);
    }

    @PutMapping("/update/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public void updateBooking(@PathVariable Long id, @RequestBody BookigDto bookingDto) {
        bookingService.updateBooking(id, bookingDto);
    }

    @DeleteMapping("/delete/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public void deleteBooking(@PathVariable Long id) {
        bookingService.deleteBooking(id);
    }
}
