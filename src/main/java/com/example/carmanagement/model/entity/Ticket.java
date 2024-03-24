package com.example.carmanagement.model.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "tickets")
public class Ticket {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    private LocalDateTime bookingTime;

    private String customerName;

    @ManyToOne
    @JoinColumn(name = "license_plate")
    private Car car;

    @ManyToOne
    @JoinColumn(name = "trip_id")
    private Trip trip;
}
