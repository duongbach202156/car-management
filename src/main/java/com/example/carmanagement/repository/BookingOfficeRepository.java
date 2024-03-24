package com.example.carmanagement.repository;

import com.example.carmanagement.model.entity.BookingOffice;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookingOfficeRepository extends JpaRepository<BookingOffice, Long> {
}