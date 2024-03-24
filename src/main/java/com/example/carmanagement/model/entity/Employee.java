package com.example.carmanagement.model.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Past;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "employees")
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    private String department;

    private String address;

    @Past
    private LocalDate birthday;

    @Email
    private String email;

    private String name;

    private String phone;

    @Enumerated(EnumType.STRING)
    private Gender sex;

    @Column(unique = true)
    private String username;

    private String password;

}
