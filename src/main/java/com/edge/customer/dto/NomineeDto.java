package com.edge.customer.dto;

import com.edge.customer.enums.NomineeType;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PastOrPresent;
import jakarta.validation.constraints.Size;
import java.time.LocalDate;
import java.util.Date;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class NomineeDto {

    @NotNull(message = "Nominee Id is required.")
    private Long id;

    @NotBlank(message = "Legal Name is required.")
    @Size(max = 100, message = "Legal Name must not exceed 100 characters.")
    private String legalName;

    @Size(max = 50, message = "First Name must not exceed 50 characters.")
    private String firstName;

    @Size(max = 50, message = "Last Name must not exceed 50 characters.")
    private String lastName;

    @NotNull(message = "Nominee type is required.")
    private NomineeType nomineeType;

    @PastOrPresent
    private LocalDate dateOfBirth;
}
