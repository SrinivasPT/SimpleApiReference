package com.edge.customer.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PastOrPresent;
import jakarta.validation.constraints.Size;
import java.time.LocalDate;
import java.util.Date;
import java.util.Set;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CustomerDto {

    @NotNull(message = "Customer ID is required.")
    private Long id;

    @NotBlank(message = "Application ID is required.")
    @Size(max = 50, message = "Application ID must be of 10 characters.")
    private String applicationId;

    @NotBlank(message = "Legal Name is required.")
    @Size(max = 100, message = "Legal Name must not exceed 100 characters.")
    private String legalName;

    @Size(max = 50, message = "First Name must not exceed 50 characters.")
    private String firstName;

    @Size(max = 50, message = "Middle Name must not exceed 50 characters.")
    private String middleName;

    @Size(max = 50, message = "Last Name must not exceed 50 characters.")
    private String lastName;

    @NotNull(message = "Date of Birth is required.")
    @PastOrPresent
    private LocalDate dateOfBirth;

    @NotBlank(message = "Account Number is required.")
    private String accountNumber;

    @NotBlank(message = "System Code is required.")
    private String systemCode;

    @NotNull(message = "Nominees are required.")
    private Set<NomineeDto> nominees;

}