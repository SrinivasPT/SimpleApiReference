package com.edge.customer.enums;

import com.edge.customer.validator.IEnum;
import java.util.Arrays;
import java.util.stream.Collectors;

public enum SystemCode implements IEnum {
    ABC("1ABC", "One Abc"),
    DEF("1DEF", "One Def"),
    GHI("1GHI", "One Ghi"),
    JKL("1JKL", "One Jkl");

    private final String code;
    private final String description;

    SystemCode(String code, String description) {
        this.code = code;
        this.description = description;
    }

    @Override
    public String getCode() {
        return code;
    }

    @Override
    public String getDescription() {
        return description;
    }

    public static String getAllTypesFormatted() {
        return Arrays.stream(SystemCode.values())
            .map(type -> type.getDescription() + "(" + type.getCode() + ")")
            .collect(Collectors.joining(", "));
    }
}
