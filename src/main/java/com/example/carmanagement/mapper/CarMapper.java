package com.example.carmanagement.mapper;

import com.example.carmanagement.model.dto.CarDto;
import com.example.carmanagement.model.dto.CarFullInfoDto;
import com.example.carmanagement.model.entity.Car;
import com.example.carmanagement.model.form.UpsertCarForm;
import org.mapstruct.*;

@Mapper(componentModel = "spring", uses = {IdToEntityMapper.class, })
public abstract class CarMapper {
    public abstract CarDto toDto(Car car);

    public abstract CarFullInfoDto toFullInfoDto(Car car);

    @BeanMapping(unmappedTargetPolicy = ReportingPolicy.IGNORE)
    @Mapping(target = "parkingIot", source = "parkingIotId")
    public abstract Car toEntity(UpsertCarForm upsertCarForm);

    @BeanMapping(unmappedTargetPolicy = ReportingPolicy.IGNORE)
    @Mapping(target = "parkingIot", source = "parkingIotId")
    public abstract Car toEntityUpdate(UpsertCarForm upsertCarForm, @MappingTarget Car car);

}
