package com.example.carmanagement.model.dto;

import com.example.carmanagement.model.entity.ParkingStatus;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ParkingIotFullInfoDto {
    private Long id;

    private Long area;

    private String name;

    private String place;

    private Long price;

    private ParkingStatus status;

    private List<CarDto> carList;
}
