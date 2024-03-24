package com.example.carmanagement.mapper;

import com.example.carmanagement.model.entity.Car;
import com.example.carmanagement.model.entity.ParkingIot;
import com.example.carmanagement.model.entity.Trip;
import com.example.carmanagement.repository.CarRepository;
import com.example.carmanagement.repository.ParkingIotRepository;
import com.example.carmanagement.repository.TripRepository;
import org.mapstruct.Mapper;
import org.springframework.beans.factory.annotation.Autowired;

@Mapper(componentModel = "spring")
public abstract class IdToEntityMapper {
    @Autowired
    private ParkingIotRepository parkingIotRepository;

    @Autowired
    private CarRepository carRepository;

    @Autowired
    private TripRepository tripRepository;

    public ParkingIot idToParkingIot(Long id) {
        if (id == null) {
            return null;
        } else {
            return parkingIotRepository.findById(id).orElseThrow();
        }
    }

    public Car idToCar(String id) {
        if (id == null) {
            return null;
        } else {
            return carRepository.findById(id).orElseThrow();
        }
    }
    public Trip idToTrip(Long id) {
        if (id == null) {
            return null;
        } else {
            return tripRepository.findById(id).orElseThrow();
        }
    }
}
