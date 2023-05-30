package com.example.my_mall.utils.validator;

import com.example.my_mall.utils.validator.impl.FlagValidatorClass;
import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.*;


@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.FIELD, ElementType.PARAMETER})
@Constraint(validatedBy = FlagValidatorClass.class)
public @interface FlagValidator {

    String[] value() default {};

    String message() default "状态不合法，仅限0， 1";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
