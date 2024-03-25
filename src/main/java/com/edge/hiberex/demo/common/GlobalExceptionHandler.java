//package com.edge.hiberex.demo.common;
//
//import java.nio.file.AccessDeniedException;
//import java.util.HashMap;
//import java.util.Map;
//import java.util.NoSuchElementException;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.http.converter.HttpMessageNotReadableException;
//import org.springframework.validation.FieldError;
//import org.springframework.validation.ObjectError;
//import org.springframework.web.bind.MethodArgumentNotValidException;
//import org.springframework.web.bind.annotation.ControllerAdvice;
//import org.springframework.web.bind.annotation.ExceptionHandler;
//import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;
//
//@ControllerAdvice
//public class GlobalExceptionHandler {
//
//    @ExceptionHandler(MethodArgumentNotValidException.class)
//    public ResponseEntity<ApiResponse<Object>> handleValidationExceptions(MethodArgumentNotValidException ex) {
//        Map<String, String> errors = new HashMap<>();
//        for (FieldError error : ex.getBindingResult().getFieldErrors()) {
//            errors.put(error.getField(), error.getDefaultMessage());
//        }
//        for (ObjectError error : ex.getBindingResult().getGlobalErrors()) {
//            errors.put(error.getObjectName(), error.getDefaultMessage());
//        }
//        ApiResponse<Object> response = ApiResponse.error(errors, "Validation failed");
//        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
//    }
//    @ExceptionHandler(HttpMessageNotReadableException.class)
//    public ResponseEntity<ApiResponse<Object>> handleHttpMessageNotReadable(HttpMessageNotReadableException ex) {
//        Map<String, String> errors = new HashMap<>();
//        errors.put("error", "Malformed JSON request. Please check the request payload.");
//        ApiResponse<Object> response = ApiResponse.error(errors, "Bad Request");
//        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
//    }
//}
