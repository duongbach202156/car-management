package com.example.carmanagement.model.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class TripDto {
    private Long id;

    private Integer bookedTicketNumber;

    private String carType;

    private LocalDate departureDate;

    private LocalDateTime departureTime;

    private String destination;

    private String driver;

    private Integer maximumOnlineTicketNumber;
}
