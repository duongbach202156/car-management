package com.example.carmanagement.model.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "cars")
public class Car {
    @Id
    @Column(name = "license_plate", nullable = false)
    private String licensePlate;

    private String color;

    private String type;

    private String company;

    @ManyToOne
    @JoinColumn(name = "park_id")
    private ParkingIot parkingIot;

    @OneToMany(mappedBy = "car")
    private List<Ticket> ticketList;
}
