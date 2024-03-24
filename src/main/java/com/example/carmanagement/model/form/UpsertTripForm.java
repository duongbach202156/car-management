package com.example.carmanagement.model.form;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UpsertTripForm {

    private String carType;

    // date
    private String departureDate;

    // date time
    private String departureTime;

    private String destination;

    private String driver;

    private Integer maximumOnlineTicketNumber;
}
