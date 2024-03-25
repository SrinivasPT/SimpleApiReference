package com.edge.customer.service;

import com.edge.customer.dto.CustomerDto;
import com.edge.customer.mapper.CustomerMapper;
import com.edge.customer.model.Customer;
import com.edge.customer.model.Nominee;
import com.edge.customer.repository.CustomerRepository;
import java.time.LocalDate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerService {

    @Autowired
    private CustomerRepository repository;

    public Customer create(CustomerDto customerDto) {
        Customer customer = CustomerMapper.INSTANCE.customerDtoToCustomer(customerDto);
        validateCustomer(customer);
        customer.getNominees().forEach(this::validateNominee);
        return repository.save(customer);
    }

    private void validateCustomer(Customer customer) {
        if (customer.getDateOfBirth().isBefore(LocalDate.of(1900, 1, 1)) ||
            customer.getDateOfBirth().isAfter(LocalDate.of(2015, 12, 31))) {
            throw new IllegalArgumentException("Invalid date of birth for customer");
        }
    }

    private void validateNominee(Nominee nominee) {
        // Validate age > 18 years and other nominee-specific rules
        // Implement age calculation from dateOfBirth and compare
    }

}
