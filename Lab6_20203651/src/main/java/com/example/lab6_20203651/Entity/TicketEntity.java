package com.example.lab6_20203651.Entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.sql.Timestamp;
import java.util.Date;
import java.util.Objects;

@Entity
@Getter
@Setter
@Table(name = "ticket", schema = "lab6")
public class TicketEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "TicketID")
    private Integer ticketId;

    @ManyToOne
    @JoinColumn(name = "SiteID")
    private SiteEntity siteId;

    @ManyToOne
    @JoinColumn(name = "TechnicianID")
    private TechnicianEntity technicianId;
    
    @Column(name = "Status")
    private String status;
    
    @Column(name = "OpenedDate")
    private Date openedDate;
    
    @Column(name = "ClosedDate")
    private Date closedDate;

}
