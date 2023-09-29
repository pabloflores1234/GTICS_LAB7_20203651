package com.example.lab6_20203651.Entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;
import lombok.Singular;

import java.util.Objects;

@Entity
@Getter
@Setter
@Table(name = "technician", schema = "lab6")
public class TechnicianEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "TechnicianID")
    private int TechnicianId;


    @NotBlank
    @Size(max=300, min = 3)
    @Column(name = "FirstName")
    private String FirstName;

    @Size(max=300, min = 3)
    @Column(name = "LastName")
    private String LastName;


    @Digits(integer = 8, fraction = 0)
    @Column(name = "Dni")
    private String Dni;

    @Digits(integer = 9, fraction = 0)
    @Column(name = "Phone")
    private String Phone;

    @Digits(integer = 2,fraction = 0)
    @Positive
    @Column(name = "Age")
    private String Age;

    
}
