package com.example.lab6_20203651.Entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Objects;

@Entity
@Getter
@Setter
@Table(name = "device", schema = "lab6")
public class DeviceEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "DeviceID")
    private Integer deviceId;
    
    @Column(name = "DeviceName")
    private String deviceName;
    
    @Column(name = "DeviceType")
    private String deviceType;
    
    @Column(name = "Model")
    private String model;
    
    @Column(name = "SerialNumber")
    private String serialNumber;

    @ManyToOne
    @JoinColumn(name = "SiteID")
    private SiteEntity site;
    
}
