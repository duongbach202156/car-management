package com.example.carmanagement.model.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CarFullInfoDto {
    private String licensePlate;

    private String color;

    private String type;

    private String company;

    private ParkingIotDto parkingIot;

    private List<TicketDto> ticketList;
}
