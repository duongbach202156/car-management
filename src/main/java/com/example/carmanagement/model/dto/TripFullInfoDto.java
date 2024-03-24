package com.example.carmanagement.model.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class TripFullInfoDto {
    private Long id;

    private Integer bookedTicketNumber;

    private String carType;

    private String departureDate;

    private String departureTime;

    private String destination;

    private String driver;

    private Integer maximumOnlineTicketNumber;

    private List<TicketDto> ticketList;

    private List<BookingOfficeDto> bookingOfficeList;
}
