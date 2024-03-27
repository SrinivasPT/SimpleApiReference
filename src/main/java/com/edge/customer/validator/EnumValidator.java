package com.edge.customer.validator;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import java.util.Arrays;
import java.util.stream.Collectors;

public class EnumValidator implements ConstraintValidator<ValidEnumValue, Object> {

    private String message;
    private Class<? extends Enum<?>> enumClass;

    @Override
    public void initialize(ValidEnumValue constraintAnnotation) {
        enumClass = constraintAnnotation.enumClass();
        this.message = constraintAnnotation.message();
    }

    @Override
    public boolean isValid(Object value, ConstraintValidatorContext context) {
        if (value == null) {
            return true;
        }

        boolean isValid = Arrays.stream(enumClass.getEnumConstants())
            .map(Enum::toString)
            .anyMatch(e -> e.equals(value.toString()));

        if (!isValid) {
            context.disableDefaultConstraintViolation();
            context.buildConstraintViolationWithTemplate(
//                message + " for " + enumClass.getSimpleName() +
                message + " Valid values are: " + getValidValues()
            ).addConstraintViolation();
        }

        return isValid;
    }

    private String getValidValues() {
        return Arrays.stream(enumClass.getEnumConstants())
            .map(e -> ((IEnum) e).getDescription() + "(" + ((IEnum) e).getCode() + ")")
            .collect(Collectors.joining(", "));
    }

}
