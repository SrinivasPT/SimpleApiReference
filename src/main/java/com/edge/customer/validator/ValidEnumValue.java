package com.edge.customer.validator;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;
import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

@Target({FIELD})
@Retention(RUNTIME)
@Constraint(validatedBy = EnumValidator.class)
@Documented
public @interface ValidEnumValue {

    String message() default "Invalid value for the enum";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

    // This attribute specifies the enum class the field should be validated against
    Class<? extends Enum<?>> enumClass();
}
