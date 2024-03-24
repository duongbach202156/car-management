package com.example.carmanagement.service.impl;

import com.example.carmanagement.model.dto.EmployeeDto;
import com.example.carmanagement.model.form.UpsertEmployeeForm;
import com.example.carmanagement.model.entity.Employee;
import com.example.carmanagement.mapper.EmployeeMapper;
import com.example.carmanagement.repository.EmployeeRepository;
import com.example.carmanagement.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Autowired
    private EmployeeMapper employeeMapper;

    @Override
    public EmployeeDto createEmployee(UpsertEmployeeForm upsertEmployeeForm) {
        Employee employee = employeeMapper.toEntity(upsertEmployeeForm);
        employee = employeeRepository.save(employee);
        return employeeMapper.toDto(employee);
    }

    @Override
    public Page<EmployeeDto> getAllEmployee(Pageable pageable) {
        Page<Employee> page = employeeRepository.findAll(pageable);
        return page.map(employeeMapper::toDto);
    }

    @Override
    public EmployeeDto getEmployeeById(Long id) {
        Employee employee = employeeRepository.findById(id).orElseThrow();
        return employeeMapper.toDto(employee);
    }

    @Override
    public EmployeeDto updateEmployee(UpsertEmployeeForm upsertEmployeeForm, Long id) {
        Employee employee = employeeRepository.findById(id).orElseThrow();
        employee = employeeMapper.toEntityUpdate(upsertEmployeeForm, employee);
        employee = employeeRepository.save(employee);
        return employeeMapper.toDto(employee);
    }

    @Override
    public void deleteEmployee(Long id) {
        employeeRepository.deleteById(id);
    }
}
