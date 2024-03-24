package com.example.carmanagement.service;

import com.example.carmanagement.model.dto.EmployeeDto;
import com.example.carmanagement.model.form.UpsertEmployeeForm;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface EmployeeService {
    EmployeeDto createEmployee(UpsertEmployeeForm upsertEmployeeForm);

    Page<EmployeeDto> getAllEmployee(Pageable pageable);

    EmployeeDto getEmployeeById(Long id);

    EmployeeDto updateEmployee(UpsertEmployeeForm upsertEmployeeForm, Long id);

    void deleteEmployee(Long id);
}
