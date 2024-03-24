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
@Table(name = "parking_iots")
public class ParkingIot {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    private Long area;

    private String name;

    private String place;

    private Long price;

    @Enumerated(EnumType.STRING)
    private ParkingStatus status;

    @OneToMany(mappedBy = "parkingIot")
    private List<Car> carList;
}
