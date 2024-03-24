package com.example.carmanagement.controller;

import com.example.carmanagement.model.dto.ParkingIotDto;
import com.example.carmanagement.model.dto.ParkingIotFullInfoDto;
import com.example.carmanagement.model.form.UpsertParkingIotForm;
import com.example.carmanagement.service.ParkingIotService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/car-management/parking-iots")
public class ParkingIotController {

    @Autowired
    private ParkingIotService parkingIotService;

    @GetMapping
    public ResponseEntity<Page<ParkingIotDto>> getAllParkingIot(Pageable pageable) {
        Page<ParkingIotDto> page = parkingIotService.getAllParkingIot(pageable);
        return new ResponseEntity<>(page, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ParkingIotFullInfoDto> getParkingIotById(@PathVariable("id") Long id) {
        ParkingIotFullInfoDto parkingIotDto = parkingIotService.getParkingIotById(id);
        return new ResponseEntity<>(parkingIotDto, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<ParkingIotFullInfoDto> createNewParkingIot(@Valid @RequestBody UpsertParkingIotForm upsertParkingIotForm) {
        ParkingIotFullInfoDto parkingIotDto = parkingIotService.createParkingIot(upsertParkingIotForm);
        return new ResponseEntity<>(parkingIotDto, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ParkingIotFullInfoDto> updateParkingIot(@Valid @RequestBody UpsertParkingIotForm upsertParkingIotForm,
                                                      @PathVariable("id") Long id) {
        ParkingIotFullInfoDto parkingIotDto = parkingIotService.updateParkingIot(upsertParkingIotForm, id);
        return new ResponseEntity<>(parkingIotDto, HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteParkingIot(@PathVariable("id") Long id) {
        parkingIotService.deleteParkingIot(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
