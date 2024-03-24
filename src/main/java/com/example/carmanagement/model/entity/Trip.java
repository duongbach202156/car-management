package com.example.carmanagement.model.entity;

import jakarta.persistence.*;
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
@Entity
@Table(name = "trips")
public class Trip {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    private Integer bookedTicketNumber = 0;

    private String carType;

    private LocalDate departureDate;

    private LocalDateTime departureTime;

    private String destination;

    private String driver;

    private Integer maximumOnlineTicketNumber;

    @OneToMany(mappedBy = "trip")
    private List<Ticket> ticketList;

    @OneToMany(mappedBy = "trip")
    private List<BookingOffice> bookingOfficeList;
}
