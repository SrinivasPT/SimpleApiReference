package com.edge.customer.service;

import com.edge.customer.dto.CustomerDto;
import com.edge.customer.mapper.CustomerMapper;
import com.edge.customer.model.Customer;
import com.edge.customer.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerService {

    @Autowired
    private CustomerRepository repository;

    public Customer create(CustomerDto customerDto) {
//        validateCustomer(customerDto);
        // customerDto.getNominees().forEach(this::validateNominee);
        Customer customer = CustomerMapper.INSTANCE.customerDtoToCustomer(customerDto);

        return repository.save(customer);
    }

//    private void validateCustomer(CustomerDto customerDto) {
//        if (customerDto.getDateOfBirth().isBefore(LocalDate.of(1900, 1, 1)) ||
//            customerDto.getDateOfBirth().isAfter(LocalDate.of(2015, 12, 31))) {
//            throw new IllegalArgumentException("Invalid date of birth for customer");
//        }
//    }

//    private void validateNominee(NomineeDto nomineeDto) {
//        // Validate age > 18 years and other nominee-specific rules
//        // Implement age calculation from dateOfBirth and compare
//    }

}
