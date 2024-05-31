package com.aspyr.core.entities;

import java.time.LocalDate;
import java.time.LocalTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "appointment")
@Data
public class AppointmentEntity {

    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    private Long id;
    private Long interviewerId;
    @Column(nullable = false)
    private Long intervieweeId;
    private String joiningLink;
    private String feedbackReport;
    private String finalRating;
    private LocalTime actualStartTime;
    private LocalTime actualEndTime;
    @Column(nullable = false)
    private LocalTime reqStartTime;
    @Column(nullable = false)
    private LocalTime reqEndTime;
    @Column(nullable = false)
    private LocalDate date;
    private String roundType;
    private String paymentEligible;
    private String reason;
    private AppointmentStatusMessage status = AppointmentStatusMessage.PENDING;
}   
