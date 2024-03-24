package com.example.carmanagement.service.impl;

import com.example.carmanagement.mapper.TripMapper;
import com.example.carmanagement.model.dto.TripDto;
import com.example.carmanagement.model.dto.TripFullInfoDto;
import com.example.carmanagement.model.entity.Trip;
import com.example.carmanagement.model.form.UpsertTripForm;
import com.example.carmanagement.repository.TripRepository;
import com.example.carmanagement.service.TripService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class TripServiceImpl implements TripService {

    @Autowired
    private TripRepository tripRepository;

    @Autowired
    private TripMapper tripMapper;

    @Override
    public TripFullInfoDto createTrip(UpsertTripForm upsertTripForm) {
        Trip trip = tripMapper.toEntity(upsertTripForm);
        trip = tripRepository.save(trip);
        return tripMapper.toFullInfoDto(trip);
    }

    @Override
    public Page<TripDto> getAllTrip(Pageable pageable) {
        Page<Trip> page = tripRepository.findAll(pageable);
        return page.map(tripMapper::toDto);
    }

    @Override
    public TripFullInfoDto getTripById(Long id) {
        Trip trip = tripRepository.findById(id).orElseThrow();
        return tripMapper.toFullInfoDto(trip);
    }

    @Override
    public TripFullInfoDto updateTrip(UpsertTripForm upsertTripForm, Long id) {
        Trip trip = tripRepository.findById(id).orElseThrow();
        trip = tripMapper.toEntityUpdate(upsertTripForm, trip);
        trip = tripRepository.save(trip);
        return tripMapper.toFullInfoDto(trip);
    }

    @Override
    public void deleteTrip(Long id) {
        tripRepository.deleteById(id);
    }
}
