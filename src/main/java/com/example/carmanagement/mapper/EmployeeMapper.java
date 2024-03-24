package com.example.carmanagement.mapper;

import com.example.carmanagement.constant.DateTimeFormat;
import com.example.carmanagement.model.dto.EmployeeDto;
import com.example.carmanagement.model.form.UpsertEmployeeForm;
import com.example.carmanagement.model.entity.Employee;
import org.mapstruct.*;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public abstract class EmployeeMapper {

    @BeanMapping(unmappedTargetPolicy = ReportingPolicy.IGNORE)
    @Mapping(target = "birthday", dateFormat = DateTimeFormat.DATE_FORMAT)
    public abstract Employee toEntity(UpsertEmployeeForm upsertEmployeeForm);

    @BeanMapping(unmappedTargetPolicy = ReportingPolicy.IGNORE)
    @Mapping(target = "username", ignore = true)
    @Mapping(target = "password", ignore = true)
    @Mapping(target = "birthday", dateFormat = DateTimeFormat.DATE_FORMAT)
    public abstract Employee toEntityUpdate(UpsertEmployeeForm upsertEmployeeForm, @MappingTarget Employee employee);

    @Mapping(target = "birthday", dateFormat = DateTimeFormat.DATE_FORMAT)
    public abstract EmployeeDto toDto(Employee employee);

}
