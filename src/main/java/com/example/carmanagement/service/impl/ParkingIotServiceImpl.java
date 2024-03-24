package com.example.carmanagement.service.impl;

import com.example.carmanagement.mapper.ParkingIotMapper;
import com.example.carmanagement.model.dto.ParkingIotDto;
import com.example.carmanagement.model.dto.ParkingIotFullInfoDto;
import com.example.carmanagement.model.entity.ParkingIot;
import com.example.carmanagement.model.form.UpsertParkingIotForm;
import com.example.carmanagement.repository.ParkingIotRepository;
import com.example.carmanagement.service.ParkingIotService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class ParkingIotServiceImpl implements ParkingIotService {

    @Autowired
    private ParkingIotRepository parkingIotRepository;

    @Autowired
    private ParkingIotMapper parkingIotMapper;

    @Override
    public ParkingIotFullInfoDto createParkingIot(UpsertParkingIotForm upsertParkingIotForm) {
        ParkingIot parkingIot = parkingIotMapper.toEntity(upsertParkingIotForm);
        parkingIot = parkingIotRepository.save(parkingIot);
        return parkingIotMapper.toFullInfoDto(parkingIot);
    }

    @Override
    public Page<ParkingIotDto> getAllParkingIot(Pageable pageable) {
        Page<ParkingIot> page = parkingIotRepository.findAll(pageable);
        return page.map(parkingIotMapper::toDto);
    }

    @Override
    public ParkingIotFullInfoDto getParkingIotById(Long id) {
        ParkingIot parkingIot = parkingIotRepository.findById(id).orElseThrow();
        return parkingIotMapper.toFullInfoDto(parkingIot);
    }

    @Override
    public ParkingIotFullInfoDto updateParkingIot(UpsertParkingIotForm upsertParkingIotForm, Long id) {
        ParkingIot parkingIot = parkingIotRepository.findById(id).orElseThrow();
        parkingIot = parkingIotMapper.toEntityUpdate(upsertParkingIotForm, parkingIot);
        parkingIot = parkingIotRepository.save(parkingIot);
        return parkingIotMapper.toFullInfoDto(parkingIot);
    }

    @Override
    public void deleteParkingIot(Long id) {
        parkingIotRepository.deleteById(id);
    }
}
