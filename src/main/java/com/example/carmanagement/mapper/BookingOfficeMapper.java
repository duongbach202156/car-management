package com.example.carmanagement.mapper;

import com.example.carmanagement.constant.DateTimeFormat;
import com.example.carmanagement.model.dto.BookingOfficeDto;
import com.example.carmanagement.model.entity.BookingOffice;
import com.example.carmanagement.model.form.UpsertBookingOfficeForm;
import org.mapstruct.*;

@Mapper(componentModel = "spring", uses = {TripMapper.class, IdToEntityMapper.class})
public abstract class BookingOfficeMapper {
    public abstract BookingOfficeDto toDto(BookingOffice bookingOffice);

    @BeanMapping(unmappedTargetPolicy = ReportingPolicy.IGNORE)
    @Mapping(target = "trip", source = "tripId")
    @Mapping(target = "endContractDeadline", dateFormat = DateTimeFormat.DATE_FORMAT)
    @Mapping(target = "startContractDeadline", dateFormat = DateTimeFormat.DATE_FORMAT)
    public abstract BookingOffice toEntity(UpsertBookingOfficeForm upsertBookingOfficeForm);

    @BeanMapping(unmappedTargetPolicy = ReportingPolicy.IGNORE)
    @Mapping(target = "trip", source = "tripId")
    @Mapping(target = "endContractDeadline", dateFormat = DateTimeFormat.DATE_FORMAT)
    @Mapping(target = "startContractDeadline", dateFormat = DateTimeFormat.DATE_FORMAT)
    public abstract BookingOffice toEntityUpdate(UpsertBookingOfficeForm upsertBookingOfficeForm, @MappingTarget BookingOffice bookingOffice);
}
