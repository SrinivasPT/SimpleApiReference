package com.edge.hiberex.demo.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class EmployeeSearchCriteria {
    private String firstName;
    private String lastName;
    private String lineOne;
}
