package com.example.carmanagement.model.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "booking_offices")
public class BookingOffice {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    private LocalDate endContractDeadline;

    private String name;

    private String phone;

    private String place;

    private Long price;

    private LocalDate startContractDeadline;

    @ManyToOne
    @JoinColumn(name = "trip_id")
    private Trip trip;
}
