package com.example.carmanagement.model.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class TicketDto {
    private Long id;

    private LocalDateTime bookingTime;

    private String customerName;

    private CarDto car;

    private TripDto trip;
}
