package com.example.lab6_20203651.Entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Objects;

@Entity
@Getter
@Setter
@Table(name = "location", schema = "lab6")
public class LocationEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "LocationID")
    private Integer locationId;
    
    @Column(name = "City")
    private String city;
    
    @Column(name = "Country")
    private String country;
    
}
