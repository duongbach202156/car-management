package com.example.carmanagement.controller;

import com.example.carmanagement.model.dto.CarDto;
import com.example.carmanagement.model.dto.CarFullInfoDto;
import com.example.carmanagement.model.entity.Car;
import com.example.carmanagement.model.form.UpsertCarForm;
import com.example.carmanagement.service.CarService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/car-management/cars")
public class CarController {
    @Autowired
    private CarService carService;

    @GetMapping
    public ResponseEntity<Page<CarDto>> getAllCar(Pageable pageable) {
        Page<CarDto> page = carService.getAllCar(pageable);
        return new ResponseEntity<>(page, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<CarFullInfoDto> getCarById(@PathVariable("id") String id) {
        CarFullInfoDto carDto = carService.getCarById(id);
        return new ResponseEntity<>(carDto, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<CarFullInfoDto> createNewCar(@Valid @RequestBody UpsertCarForm upsertCarForm) {
        CarFullInfoDto carDto = carService.createCar(upsertCarForm);
        return new ResponseEntity<>(carDto, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<CarFullInfoDto> updateCar(@Valid @RequestBody UpsertCarForm upsertCarForm,
                                                      @PathVariable("id") String id) {
        CarFullInfoDto carDto = carService.updateCar(upsertCarForm, id);
        return new ResponseEntity<>(carDto, HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteCar(@PathVariable("id") String id) {
        carService.deleteCar(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
