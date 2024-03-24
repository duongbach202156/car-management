package com.example.carmanagement.model.dto;

import com.example.carmanagement.model.entity.ParkingStatus;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ParkingIotDto implements Serializable {
    private Long id;

    private Long area;

    private String name;

    private String place;

    private Long price;

    private ParkingStatus status;

}
