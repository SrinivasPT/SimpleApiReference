package com.edge.customer.model;

import com.edge.customer.dto.NomineeDto;
import com.edge.customer.enums.NomineeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
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
public class Nominee extends Auditable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Legal Name is required.")
    @Size(max = 100, message = "Legal Name must not exceed 100 characters.")
    private String legalName;

    @NotBlank
    private String firstName;

    @NotBlank
    private String lastName;

    @NotNull(message = "Nominee type is required.")
    private NomineeType nomineeType;

    @PastOrPresent
    private LocalDate dateOfBirth;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "customer_id")
    private Customer customer;
}
