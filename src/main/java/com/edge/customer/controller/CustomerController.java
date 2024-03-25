package com.edge.customer.controller;

import com.edge.customer.dto.CustomerDto;
import com.edge.customer.model.Customer;
import com.edge.customer.service.CustomerService;
import com.edge.customer.service.ValidationService;
import jakarta.validation.Valid;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/customers")
public class CustomerController {

    @Autowired
    CustomerService service;
    @Autowired
    ValidationService validationService;

    @PostMapping
    public ResponseEntity<?> create(@Valid @RequestBody CustomerDto customerDto, BindingResult bindingResult) {
        List<String> errors = validationService.validate(customerDto);
        if (!errors.isEmpty() || bindingResult.hasErrors()) {
            bindingResult.getAllErrors().forEach(error -> errors.add(error.getDefaultMessage()));
            return ResponseEntity.badRequest().body(errors);
        }
        Customer createdCustomer = service.create(customerDto);
        return ResponseEntity.ok(createdCustomer);
    }

}
