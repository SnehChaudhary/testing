package com.aspyr.core.dao;

import java.time.LocalDate;
import java.time.LocalTime;


import lombok.Data;

@Data
public class InterviewRequestDAO {
    private Long intervieweeId;
    private String roundType;
    private LocalTime startTime;
    private LocalTime endTime;
    private LocalDate date;
}
