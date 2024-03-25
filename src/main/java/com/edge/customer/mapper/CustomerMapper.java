package com.edge.customer.mapper;

import com.edge.customer.dto.CustomerDto;
import com.edge.customer.dto.NomineeDto;
import com.edge.customer.model.Customer;
import com.edge.customer.model.Nominee;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface CustomerMapper {

    CustomerMapper INSTANCE = Mappers.getMapper(CustomerMapper.class);

    Customer customerDtoToCustomer(CustomerDto customerDto);

    CustomerDto customerToCustomerDto(Customer customer);

    Nominee nomineeDtoToNominee(NomineeDto nomineeDto);

    NomineeDto nomineeToNomineeDto(Nominee nominee);
}
