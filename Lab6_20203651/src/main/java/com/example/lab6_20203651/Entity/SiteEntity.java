package com.example.lab6_20203651.Entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.sql.Date;
import java.util.Objects;

@Entity
@Getter
@Setter
@Table(name = "site", schema = "lab6")
public class SiteEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "SiteID")
    private Integer siteId;
    
    @Column(name = "SiteName")
    private String siteName;

    @ManyToOne
    @JoinColumn(name = "LocationID")
    private LocationEntity location;
    
    @Column(name = "InstallationDate")
    private Date installationDate;
    
    @Column(name = "Latitude")
    private String latitude;
    
    @Column(name = "Longitude")
    private String longitude;

}
