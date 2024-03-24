package com.example.carmanagement.model.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class BookingOfficeDto {
    private LocalDate endContractDeadline;

    private String name;

    private String phone;

    private String place;

    private Long price;

    private LocalDate startContractDeadline;

    private TripDto trip;
}
