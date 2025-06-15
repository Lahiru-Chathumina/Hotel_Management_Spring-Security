package org.example.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
@Table(name = "Booking")
public class BookingEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long bookigid;
    private LocalDate bookingDate;

    @ManyToOne
    @JoinColumn(name = "customer_id",nullable = false)
    private CustomerEntity customer;

    @ManyToOne
    @JoinColumn(name = "room_id", nullable = false)
    private RoomEntity room;
}
