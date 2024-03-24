package com.example.carmanagement.service;

import com.example.carmanagement.model.dto.CarDto;
import com.example.carmanagement.model.dto.CarFullInfoDto;
import com.example.carmanagement.model.form.UpsertCarForm;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface CarService {
    CarFullInfoDto createCar(UpsertCarForm upsertCarForm);

    Page<CarDto> getAllCar(Pageable pageable);

    CarFullInfoDto getCarById(String id);

    CarFullInfoDto updateCar(UpsertCarForm upsertCarForm, String id);

    void deleteCar(String id);
}
