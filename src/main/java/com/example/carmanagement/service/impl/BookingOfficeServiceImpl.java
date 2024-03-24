package com.example.carmanagement.service.impl;

import com.example.carmanagement.mapper.BookingOfficeMapper;
import com.example.carmanagement.model.dto.BookingOfficeDto;
import com.example.carmanagement.model.entity.BookingOffice;
import com.example.carmanagement.model.form.UpsertBookingOfficeForm;
import com.example.carmanagement.repository.BookingOfficeRepository;
import com.example.carmanagement.service.BookingOfficeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class BookingOfficeServiceImpl implements BookingOfficeService {

    @Autowired
    private BookingOfficeRepository bookingOfficeRepository;

    @Autowired
    private BookingOfficeMapper bookingOfficeMapper;

    @Override
    public BookingOfficeDto createBookingOffice(UpsertBookingOfficeForm upsertBookingOfficeForm) {
        BookingOffice bookingOffice = bookingOfficeMapper.toEntity(upsertBookingOfficeForm);
        bookingOffice = bookingOfficeRepository.save(bookingOffice);
        return bookingOfficeMapper.toDto(bookingOffice);
    }

    @Override
    public Page<BookingOfficeDto> getAllBookingOffice(Pageable pageable) {
        Page<BookingOffice> page = bookingOfficeRepository.findAll(pageable);
        return page.map(bookingOfficeMapper::toDto);
    }

    @Override
    public BookingOfficeDto getBookingOfficeById(Long id) {
        BookingOffice bookingOffice = bookingOfficeRepository.findById(id).orElseThrow();
        return bookingOfficeMapper.toDto(bookingOffice);
    }

    @Override
    public BookingOfficeDto updateBookingOffice(UpsertBookingOfficeForm upsertBookingOfficeForm, Long id) {
        BookingOffice bookingOffice = bookingOfficeRepository.findById(id).orElseThrow();
        bookingOffice = bookingOfficeMapper.toEntityUpdate(upsertBookingOfficeForm, bookingOffice);
        bookingOffice = bookingOfficeRepository.save(bookingOffice);
        return bookingOfficeMapper.toDto(bookingOffice);
    }

    @Override
    public void deleteBookingOffice(Long id) {
        bookingOfficeRepository.deleteById(id);
    }
}
