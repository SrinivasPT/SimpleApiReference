package com.edge.customer.enums;

import com.edge.customer.validator.IEnum;
import java.util.Arrays;
import java.util.stream.Collectors;

public enum NomineeType implements IEnum {
    MAJOR("MAJOR", "Major"), MINOR("MINOR", "Minor");
    private final String code;
    private final String description;

    NomineeType(String code, String description) {
        this.code = code;
        this.description = description;
    }

    public static String getAllTypesFormatted() {
        return Arrays.stream(SystemCode.values())
            .map(type -> type.getDescription() + "(" + type.getCode() + ")")
            .collect(Collectors.joining(", "));
    }

    @Override
    public String getCode() {
        return code;
    }

    @Override
    public String getDescription() {
        return description;
    }
}