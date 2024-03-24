package com.example.carmanagement.service.impl;

import com.example.carmanagement.exception.TripIsFullException;
import com.example.carmanagement.mapper.TicketMapper;
import com.example.carmanagement.model.dto.TicketDto;
import com.example.carmanagement.model.entity.Ticket;
import com.example.carmanagement.model.entity.Trip;
import com.example.carmanagement.model.form.UpsertTicketForm;
import com.example.carmanagement.repository.TicketRepository;
import com.example.carmanagement.repository.TripRepository;
import com.example.carmanagement.service.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
public class TicketServiceImpl implements TicketService {

    @Autowired
    private TicketRepository ticketRepository;

    @Autowired
    private TicketMapper ticketMapper;

    @Autowired
    private TripRepository tripRepository;

    @Override
    public TicketDto createTicket(UpsertTicketForm upsertTicketForm) {
        Trip trip = tripRepository.findById(upsertTicketForm.getTripId()).orElseThrow();
        if (Objects.equals(trip.getBookedTicketNumber(), trip.getMaximumOnlineTicketNumber())) {
            throw new TripIsFullException("Trip is out of ticket");
        } else {
            trip.setBookedTicketNumber(trip.getBookedTicketNumber() + 1);
            tripRepository.save(trip);
            Ticket ticket = ticketMapper.toEntity(upsertTicketForm);
            ticket = ticketRepository.save(ticket);
            return ticketMapper.toDto(ticket);
        }

    }

    @Override
    public Page<TicketDto> getAllTicket(Pageable pageable) {
        Page<Ticket> page = ticketRepository.findAll(pageable);
        return page.map(ticketMapper::toDto);
    }

    @Override
    public TicketDto getTicketById(Long id) {
        Ticket ticket = ticketRepository.findById(id).orElseThrow();
        return ticketMapper.toDto(ticket);
    }

    @Override
    public TicketDto updateTicket(UpsertTicketForm upsertTicketForm, Long id) {
        Trip trip = tripRepository.findById(upsertTicketForm.getTripId()).orElseThrow();
        if (Objects.equals(trip.getBookedTicketNumber(), trip.getMaximumOnlineTicketNumber())) {
            throw new TripIsFullException("Trip is out of ticket");
        } else {
            trip.setBookedTicketNumber(trip.getBookedTicketNumber() + 1);
            tripRepository.save(trip);
            Ticket ticket = ticketRepository.findById(id).orElseThrow();
            ticket = ticketMapper.toEntityUpdate(upsertTicketForm, ticket);
            ticket = ticketRepository.save(ticket);
            return ticketMapper.toDto(ticket);
        }
    }

    @Override
    public void deleteTicket(Long id) {
        Ticket ticket = ticketRepository.findById(id).orElseThrow();
        Trip trip = tripRepository.findById(ticket.getTrip().getId()).orElseThrow();
        trip.setBookedTicketNumber(trip.getBookedTicketNumber() - 1);
        tripRepository.save(trip);
        ticketRepository.deleteById(id);
    }
}
