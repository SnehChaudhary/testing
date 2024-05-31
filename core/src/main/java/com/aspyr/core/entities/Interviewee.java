package com.aspyr.core.entities;

import java.util.*;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Data;


@Entity
@Table(name = "interviewee")
@Data
public class Interviewee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(nullable = false)
    private String name;
    @Column(unique = true,nullable = false)
    private String email;
    private Boolean emailVerified=false;
    @Column(nullable = false)
    private String phoneNo;
    private Boolean phoneNoVerified=false;
    @OneToOne(cascade = CascadeType.ALL)
    private College college;
    @Column(nullable = false)
    private String resume;
    @OneToMany(cascade = CascadeType.ALL,mappedBy = "id")
    private List<AppointmentEntity> appointments;
}
