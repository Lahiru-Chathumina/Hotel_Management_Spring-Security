package org.example.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.example.entity.CustomerEntity;
import org.example.entity.RoomEntity;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString

public class BookigDto {
    private Long bookigid;
    private LocalDate bookingDate;
    private CustomerEntity customer;
    private RoomEntity room;

}
