package com.example.carmanagement.service;

import com.example.carmanagement.model.dto.TripDto;
import com.example.carmanagement.model.dto.TripFullInfoDto;
import com.example.carmanagement.model.form.UpsertTripForm;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface TripService {
    TripFullInfoDto createTrip(UpsertTripForm upsertTripForm);

    Page<TripDto> getAllTrip(Pageable pageable);

    TripFullInfoDto getTripById(Long id);

    TripFullInfoDto updateTrip(UpsertTripForm upsertTripForm, Long id);

    void deleteTrip(Long id);
}
