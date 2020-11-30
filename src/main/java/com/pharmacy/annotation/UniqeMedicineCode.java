package com.pharmacy.annotation;

import com.pharmacy.annotation.validator.UniqeMedicineCodeValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ ElementType.FIELD })
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = {UniqeMedicineCodeValidator.class})
public @interface UniqeMedicineCode {

    String message();

    Class<?>[] groups() default { };

    Class<? extends Payload>[] payload() default { };
}
