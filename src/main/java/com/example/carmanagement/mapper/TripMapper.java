package com.example.carmanagement.mapper;

import com.example.carmanagement.constant.DateTimeFormat;
import com.example.carmanagement.model.dto.TripDto;
import com.example.carmanagement.model.dto.TripFullInfoDto;
import com.example.carmanagement.model.entity.Trip;
import com.example.carmanagement.model.form.UpsertTripForm;
import org.mapstruct.*;

@Mapper(componentModel = "spring")
public abstract class TripMapper {
    public abstract TripDto toDto(Trip trip);

    public abstract TripFullInfoDto toFullInfoDto(Trip trip);
    @Mapping(target = "departureDate", dateFormat = DateTimeFormat.DATE_FORMAT)
    @Mapping(target = "departureTime", dateFormat = DateTimeFormat.DATE_TIME_FORMAT)
    @BeanMapping(unmappedTargetPolicy = ReportingPolicy.IGNORE)
    public abstract Trip toEntity(UpsertTripForm upsertTripForm);

    @Mapping(target = "departureDate", dateFormat = DateTimeFormat.DATE_FORMAT)
    @Mapping(target = "departureTime", dateFormat = DateTimeFormat.DATE_TIME_FORMAT)
    @BeanMapping(unmappedTargetPolicy = ReportingPolicy.IGNORE)
    public abstract Trip toEntityUpdate(UpsertTripForm upsertTripForm, @MappingTarget Trip trip);
}
