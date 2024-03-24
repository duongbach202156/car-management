package com.example.carmanagement.response;

import lombok.*;
import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;
import java.util.List;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class GenericResponse<D> {
    private final LocalDateTime timestamp = LocalDateTime.now();

    private D data;

    private HttpStatus code = HttpStatus.OK;

    private String message = "success";

    private Boolean success = true;

    private List<String> errors;

}
