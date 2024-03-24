package com.example.carmanagement.model.form;

import com.example.carmanagement.model.entity.Trip;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UpsertBookingOfficeForm {
    // date
    private String endContractDeadline;

    private String name;

    private String phone;

    private String place;

    private Long price;

    // date
    private String startContractDeadline;

    private Long tripId;
}
