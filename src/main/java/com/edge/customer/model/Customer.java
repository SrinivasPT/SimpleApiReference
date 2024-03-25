package com.edge.customer.model;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PastOrPresent;
import jakarta.validation.constraints.Size;
import java.time.LocalDate;
import java.util.Set;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Customer extends Auditable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "customer")
    private Set<Nominee> nominees;
}
