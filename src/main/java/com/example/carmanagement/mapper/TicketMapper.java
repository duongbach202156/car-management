package com.example.carmanagement.mapper;

import com.example.carmanagement.constant.DateTimeFormat;
import com.example.carmanagement.model.dto.TicketDto;
import com.example.carmanagement.model.entity.Ticket;
import com.example.carmanagement.model.form.UpsertTicketForm;
import org.mapstruct.*;

@Mapper(componentModel = "spring", uses = {IdToEntityMapper.class})
public abstract class TicketMapper {

    public abstract TicketDto toDto(Ticket ticket);

    @BeanMapping(unmappedTargetPolicy = ReportingPolicy.IGNORE)
    @Mapping(target = "trip", source = "tripId")
    @Mapping(target = "car", source = "carId")
    @Mapping(target = "bookingTime", dateFormat = DateTimeFormat.DATE_TIME_FORMAT)
    public abstract Ticket toEntity(UpsertTicketForm upsertTicketForm);

    @BeanMapping(unmappedTargetPolicy = ReportingPolicy.IGNORE)
    @Mapping(target = "trip", source = "tripId")
    @Mapping(target = "car", source = "carId")
    @Mapping(target = "bookingTime", dateFormat = DateTimeFormat.DATE_TIME_FORMAT)
    public abstract Ticket toEntityUpdate(UpsertTicketForm upsertTicketForm, @MappingTarget Ticket ticket);
}
