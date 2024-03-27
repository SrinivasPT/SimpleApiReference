package com.edge.customer.service;

import com.edge.customer.dto.CustomerDto;
import com.edge.customer.dto.NomineeDto;
import com.edge.customer.enums.NomineeType;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import org.springframework.stereotype.Service;

@Service
public class ValidationService {

    public List<String> validate(CustomerDto customerDto) {
        List<String> errors = new ArrayList<>(validateCustomerDto(customerDto));
        customerDto.getNominees().forEach(nominee -> errors.addAll(validateNomineeDto(nominee)));
        return errors;
    }

    private List<String> validateCustomerDto(CustomerDto customerDto) {
        // Add customer-specific validations
        return new ArrayList<>();
    }

    private List<String> validateNomineeDto(NomineeDto nomineeDto) {
        List<String> errors = new ArrayList<>();
        if (Objects.equals(nomineeDto.getNomineeType(), NomineeType.MINOR.toString()) && nomineeDto.getDateOfBirth() == null) {
            errors.add("For minor, data of birth is required.");
        }
        return errors;
    }
}
