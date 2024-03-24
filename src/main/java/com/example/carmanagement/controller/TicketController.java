package com.example.carmanagement.controller;

import com.example.carmanagement.model.dto.TicketDto;
import com.example.carmanagement.model.form.UpsertTicketForm;
import com.example.carmanagement.service.TicketService;
import com.example.carmanagement.service.TicketService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
@RestController
@RequestMapping("/api/v1/car-management/tickets")
public class TicketController {
    @Autowired
    private TicketService ticketService;

    @GetMapping
    public ResponseEntity<Page<TicketDto>> getAllTicket(Pageable pageable) {
        Page<TicketDto> page = ticketService.getAllTicket(pageable);
        return new ResponseEntity<>(page, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<TicketDto> getTicketById(@PathVariable("id") Long id) {
        TicketDto ticketDto = ticketService.getTicketById(id);
        return new ResponseEntity<>(ticketDto, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<TicketDto> createNewTicket(@Valid @RequestBody UpsertTicketForm upsertTicketForm) {
        TicketDto ticketDto = ticketService.createTicket(upsertTicketForm);
        return new ResponseEntity<>(ticketDto, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<TicketDto> updateTicket(@Valid @RequestBody UpsertTicketForm upsertTicketForm,
                                                                  @PathVariable("id") Long id) {
        TicketDto ticketDto = ticketService.updateTicket(upsertTicketForm, id);
        return new ResponseEntity<>(ticketDto, HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteTicket(@PathVariable("id") Long id) {
        ticketService.deleteTicket(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
