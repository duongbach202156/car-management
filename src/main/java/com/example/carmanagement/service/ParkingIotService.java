package com.example.carmanagement.service;

import com.example.carmanagement.model.dto.ParkingIotDto;
import com.example.carmanagement.model.dto.ParkingIotFullInfoDto;
import com.example.carmanagement.model.form.UpsertParkingIotForm;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ParkingIotService {
    ParkingIotFullInfoDto createParkingIot(UpsertParkingIotForm upsertParkingIotForm);

    Page<ParkingIotDto> getAllParkingIot(Pageable pageable);

    ParkingIotFullInfoDto getParkingIotById(Long id);

    ParkingIotFullInfoDto updateParkingIot(UpsertParkingIotForm upsertParkingIotForm, Long id);

    void deleteParkingIot(Long id);
}
