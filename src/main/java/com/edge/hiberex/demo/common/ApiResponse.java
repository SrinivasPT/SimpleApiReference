package com.edge.hiberex.demo.common;

import java.util.Map;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ApiResponse<T> {

    private T data;
    private Map<String, String> errors;
    private String message;

    // Static method to easily create a successful response
    public static <T> ApiResponse<T> success(T data) {
        return new ApiResponse<>(data, null, null);
    }

    // Static method to easily create an error response
    public static <T> ApiResponse<T> error(Map<String, String> errors, String message) {
        return new ApiResponse<>(null, errors, message);
    }
}
