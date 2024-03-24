package com.example.carmanagement.model.dto;

import com.example.carmanagement.model.entity.Employee;
import lombok.*;

import java.io.Serializable;
import java.time.LocalDate;

/**
 * DTO for {@link Employee}
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeDto implements Serializable {

    private Long id;

    private String department;

    private String address;

    private String birthday;

    private String email;

    private String name;

    private String phone;

    private String sex;
}