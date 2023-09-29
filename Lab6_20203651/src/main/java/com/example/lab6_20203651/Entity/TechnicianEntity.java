package com.example.lab6_20203651.Entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Objects;

@Entity
@Getter
@Setter
@Table(name = "technician", schema = "lab6")
public class TechnicianEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "TechnicianID")
    private Integer technicianId;
    
    @Column(name = "FirstName")
    private String firstName;
    
    @Column(name = "LastName")
    private String lastName;
    
    @Column(name = "Email")
    private String email;
    
    @Column(name = "Phone")
    private String phone;
    
}
