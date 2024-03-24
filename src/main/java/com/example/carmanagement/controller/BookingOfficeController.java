package com.example.carmanagement.controller;

import com.example.carmanagement.model.dto.BookingOfficeDto;
import com.example.carmanagement.model.form.UpsertBookingOfficeForm;
import com.example.carmanagement.service.BookingOfficeService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/car-management/booking-offices")
public class BookingOfficeController {
    @Autowired
    private BookingOfficeService bookingOfficeService;

    @GetMapping
    public ResponseEntity<Page<BookingOfficeDto>> getAllBookingOffice(Pageable pageable) {
        Page<BookingOfficeDto> page = bookingOfficeService.getAllBookingOffice(pageable);
        return new ResponseEntity<>(page, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<BookingOfficeDto> getBookingOfficeById(@PathVariable("id") Long id) {
        BookingOfficeDto bookingOfficeDto = bookingOfficeService.getBookingOfficeById(id);
        return new ResponseEntity<>(bookingOfficeDto, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<BookingOfficeDto> createNewBookingOffice(@Valid @RequestBody UpsertBookingOfficeForm upsertBookingOfficeForm) {
        BookingOfficeDto bookingOfficeDto = bookingOfficeService.createBookingOffice(upsertBookingOfficeForm);
        return new ResponseEntity<>(bookingOfficeDto, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<BookingOfficeDto> updateBookingOffice(@Valid @RequestBody UpsertBookingOfficeForm upsertBookingOfficeForm,
                                                  @PathVariable("id") Long id) {
        BookingOfficeDto bookingOfficeDto = bookingOfficeService.updateBookingOffice(upsertBookingOfficeForm, id);
        return new ResponseEntity<>(bookingOfficeDto, HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteBookingOffice(@PathVariable("id") Long id) {
        bookingOfficeService.deleteBookingOffice(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
