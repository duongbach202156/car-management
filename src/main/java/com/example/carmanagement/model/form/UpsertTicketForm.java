package com.example.carmanagement.model.form;

import com.example.carmanagement.model.entity.Car;
import com.example.carmanagement.model.entity.Trip;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UpsertTicketForm {
    // date time
    private String bookingTime;

    private String customerName;

    private String carId;

    private Long tripId;
}
