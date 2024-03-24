package com.example.carmanagement.model.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CarDto {
    private String licensePlate;

    private String color;

    private String type;

    private String company;

    private ParkingIotDto parkingIot;

}
