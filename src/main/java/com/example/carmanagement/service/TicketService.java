package com.example.carmanagement.service;

import com.example.carmanagement.model.dto.TicketDto;
import com.example.carmanagement.model.form.UpsertTicketForm;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface TicketService {
    TicketDto createTicket(UpsertTicketForm upsertTicketForm);

    Page<TicketDto> getAllTicket(Pageable pageable);

    TicketDto getTicketById(Long id);

    TicketDto updateTicket(UpsertTicketForm upsertTicketForm, Long id);

    void deleteTicket(Long id);
}
