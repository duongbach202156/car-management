package com.example.carmanagement.model.form;

import com.example.carmanagement.model.entity.ParkingIot;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UpsertCarForm implements Serializable {
    private String licensePlate;

    private String color;

    private String type;

    private String company;

    private Long parkingIotId;
}
