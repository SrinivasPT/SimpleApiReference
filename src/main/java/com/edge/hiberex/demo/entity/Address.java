package com.edge.hiberex.demo.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "Address")
@Data
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String typeCode;
    private String lineOne;
    private String lineTwo;
    private int zip;

    @ManyToOne
    @JoinColumn(name = "employeeId", referencedColumnName = "id")
    @JsonBackReference
    private Employee employee;
}
