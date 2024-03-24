package com.example.carmanagement.service;

import com.example.carmanagement.model.dto.BookingOfficeDto;
import com.example.carmanagement.model.form.UpsertBookingOfficeForm;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface BookingOfficeService {
    BookingOfficeDto createBookingOffice(UpsertBookingOfficeForm upsertBookingOfficeForm);

    Page<BookingOfficeDto> getAllBookingOffice(Pageable pageable);

    BookingOfficeDto getBookingOfficeById(Long id);

    BookingOfficeDto updateBookingOffice(UpsertBookingOfficeForm upsertBookingOfficeForm, Long id);

    void deleteBookingOffice(Long id);
}
