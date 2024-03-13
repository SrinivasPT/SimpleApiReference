package com.edge.hiberex.demo.dto;


import jakarta.validation.constraints.PastOrPresent;
import jakarta.validation.constraints.Size;
import java.time.LocalDate;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class EmployeeSearchCriteria {

    @Size(max = 10, message = "First name cannot be longer than 10 characters")
    private String firstName;

    @Size(max = 10, message = "Last name cannot be longer than 10 characters")
    private String lastName;

    @PastOrPresent(message = "Date of birth cannot be in the future")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate dateOfBirth;

    private String lineOne;
}
