package com.example.carmanagement.controller;

import com.example.carmanagement.model.dto.EmployeeDto;
import com.example.carmanagement.model.form.UpsertEmployeeForm;
import com.example.carmanagement.service.EmployeeService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/car-management/employees")
public class EmployeeController {
    @Autowired
    private EmployeeService employeeService;

    @GetMapping
    public ResponseEntity<Page<EmployeeDto>> getAllEmployee(Pageable pageable) {
        Page<EmployeeDto> page = employeeService.getAllEmployee(pageable);
        return new ResponseEntity<>(page, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<EmployeeDto> getEmployeeById(@PathVariable("id") Long id) {
        EmployeeDto employeeDto = employeeService.getEmployeeById(id);
        return new ResponseEntity<>(employeeDto, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<EmployeeDto> createNewEmployee(@Valid @RequestBody UpsertEmployeeForm upsertEmployeeForm) {
        EmployeeDto employeeDto = employeeService.createEmployee(upsertEmployeeForm);
        return new ResponseEntity<>(employeeDto, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<EmployeeDto> updateEmployee(@Valid @RequestBody UpsertEmployeeForm upsertEmployeeForm,
                                                      @PathVariable("id") Long id) {
        EmployeeDto employeeDto = employeeService.updateEmployee(upsertEmployeeForm, id);
        return new ResponseEntity<>(employeeDto, HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<EmployeeDto> deleteEmployee(@PathVariable("id") Long id) {
        employeeService.deleteEmployee(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
