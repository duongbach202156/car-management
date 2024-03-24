package com.example.carmanagement.controller;

import com.example.carmanagement.model.dto.TripDto;
import com.example.carmanagement.model.dto.TripFullInfoDto;
import com.example.carmanagement.model.form.UpsertTripForm;
import com.example.carmanagement.service.TripService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/car-management/trips")
public class TripController {
    @Autowired
    private TripService tripService;

    @GetMapping
    public ResponseEntity<Page<TripDto>> getAllTrip(Pageable pageable) {
        Page<TripDto> page = tripService.getAllTrip(pageable);
        return new ResponseEntity<>(page, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<TripFullInfoDto> getTripById(@PathVariable("id") Long id) {
        TripFullInfoDto tripDto = tripService.getTripById(id);
        return new ResponseEntity<>(tripDto, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<TripFullInfoDto> createNewTrip(@Valid @RequestBody UpsertTripForm upsertTripForm) {
        TripFullInfoDto tripDto = tripService.createTrip(upsertTripForm);
        return new ResponseEntity<>(tripDto, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<TripFullInfoDto> updateTrip(@Valid @RequestBody UpsertTripForm upsertTripForm,
                                                                  @PathVariable("id") Long id) {
        TripFullInfoDto tripDto = tripService.updateTrip(upsertTripForm, id);
        return new ResponseEntity<>(tripDto, HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteTrip(@PathVariable("id") Long id) {
        tripService.deleteTrip(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
