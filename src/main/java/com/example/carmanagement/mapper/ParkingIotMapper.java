package com.example.carmanagement.mapper;

import com.example.carmanagement.model.dto.ParkingIotDto;
import com.example.carmanagement.model.dto.ParkingIotFullInfoDto;
import com.example.carmanagement.model.entity.ParkingIot;
import com.example.carmanagement.model.form.UpsertParkingIotForm;
import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring")
public abstract class ParkingIotMapper {
    public abstract ParkingIotDto toDto(ParkingIot parkingIot);

    public abstract ParkingIotFullInfoDto toFullInfoDto(ParkingIot parkingIot);
    @BeanMapping(unmappedTargetPolicy = ReportingPolicy.IGNORE)
    public abstract ParkingIot toEntity(UpsertParkingIotForm upsertParkingIotForm);
    @BeanMapping(unmappedTargetPolicy = ReportingPolicy.IGNORE)
    public abstract ParkingIot toEntityUpdate(UpsertParkingIotForm upsertParkingIotForm,@MappingTarget ParkingIot parkingIot);

}
