package com.aspyr.core.entities;

import java.util.*;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;


@Entity
@Table(name = "interviewer")
@Data
public class Interviewer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(nullable = false)
    private String name;
    @Column(nullable = false,unique = true) 
    private String email;
    private Boolean emailVerified=false;
    @Column(nullable = false) 
    private String phoneNo;
    private Boolean phoneNoVerified=false;
    @Column(nullable = false) 
    private String profile;
    @Column(nullable = false) 
    private RoundType roundType;
    @OneToMany( mappedBy ="id", cascade = CascadeType.ALL)
    private List<DayAvailability> dayAvailability = new ArrayList<DayAvailability>();
    @OneToMany(mappedBy ="id", cascade = CascadeType.ALL)
    private List<DateUnavailability> dateUnavailability = new ArrayList<DateUnavailability >();
    @Column(nullable = false)
    private String upiId;
    // EMAIL GOOGLE
    private Provider provider=Provider.EMAIL;
    private Long providerId;
    @OneToMany(cascade = CascadeType.ALL,mappedBy = "id")
    private List<AppointmentEntity> appointments;

}
