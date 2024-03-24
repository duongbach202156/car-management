package com.example.carmanagement.service.impl;

import com.example.carmanagement.mapper.CarMapper;
import com.example.carmanagement.model.dto.CarDto;
import com.example.carmanagement.model.dto.CarFullInfoDto;
import com.example.carmanagement.model.entity.Car;
import com.example.carmanagement.model.form.UpsertCarForm;
import com.example.carmanagement.repository.CarRepository;
import com.example.carmanagement.service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class CarServiceImpl implements CarService {
    @Autowired
    private CarRepository carRepository;

    @Autowired
    private CarMapper carMapper;

    @Override
    public CarFullInfoDto createCar(UpsertCarForm upsertCarForm) {
        Car car = carMapper.toEntity(upsertCarForm);
        return carMapper.toFullInfoDto(carRepository.save(car));
    }

    @Override
    public Page<CarDto> getAllCar(Pageable pageable) {
        Page<Car> page = carRepository.findAll(pageable);
        return page.map(carMapper::toDto);
    }

    @Override
    public CarFullInfoDto getCarById(String id) {
        Car car = carRepository.findById(id).orElseThrow();
        return carMapper.toFullInfoDto(car);
    }

    @Override
    public CarFullInfoDto updateCar(UpsertCarForm upsertCarForm, String id) {
        Car car = carRepository.findById(id).orElseThrow();
        car = carMapper.toEntityUpdate(upsertCarForm, car);
        car = carRepository.save(car);
        return carMapper.toFullInfoDto(car);
    }

    @Override
    public void deleteCar(String id) {
        carRepository.deleteById(id);
    }
}
