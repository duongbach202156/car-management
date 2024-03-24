package com.example.carmanagement.model.form;

import com.example.carmanagement.model.entity.Gender;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Past;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UpsertEmployeeForm implements Serializable {


    private String username;

    private String password;

    private String department;

    private String address;

    // date
    private String birthday;

    @Email
    private String email;

    private String name;

    private String phone;

    private Gender sex;

}
