package com.example.carmanagement.repository;

import com.example.carmanagement.model.dto.ParkingIotDto;
import com.example.carmanagement.model.entity.ParkingIot;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ParkingIotRepository extends JpaRepository<ParkingIot, Long> {

}