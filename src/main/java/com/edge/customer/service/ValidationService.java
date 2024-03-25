package com.edge.customer.service;

import com.edge.customer.dto.CustomerDto;
import com.edge.customer.dto.NomineeDto;
import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class ValidationService {

    public List<String> validate(Object dto) {
        if (dto instanceof CustomerDto) {
            return validateCustomerDto((CustomerDto) dto);
        } else if (dto instanceof NomineeDto) {
            return validateNomineeDto((NomineeDto) dto);
        }
        return new ArrayList<>();
    }

    private List<String> validateCustomerDto(CustomerDto customerDto) {
        List<String> errors = new ArrayList<>();
        // Add customer-specific validations
        return errors;
    }

    private List<String> validateNomineeDto(NomineeDto nomineeDto) {
        List<String> errors = new ArrayList<>();
        // Add nominee-specific validations
        return errors;
    }
}
