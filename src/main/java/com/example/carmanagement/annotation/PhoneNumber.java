package com.example.carmanagement.annotation;

import com.example.carmanagement.validator.PasswordValidator;
import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = PasswordValidator.class)
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
public @interface Password {
    String message() default "Password must at least 8 characters include uppercase,lowercase and number.";

    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
