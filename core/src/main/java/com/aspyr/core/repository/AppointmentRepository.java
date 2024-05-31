package com.aspyr.core.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.aspyr.core.entities.AppointmentEntity;

@Repository
public interface AppointmentRepository extends JpaRepository<AppointmentEntity,Long>{

    @Query(value = "SELECT * FROM appointment WHERE intervieweeId=?1 AND status != PENDING AND status != SCHEDULED")
    List<AppointmentEntity> getIntervieweePastMeetings(long intervieweeId);
    
    // @Query(value = "SELECT * FROM appointment WHERE intervieweeId=?1 AND (status = PENDING OR status = SCHEDULED)")
    // List<AppointmentEntity> getIntervieweeFutMeetings(long intervieweeId);
    
    // @Query(value = "SELECT * FROM appointment WHERE interviewerId=?1 AND status != PENDING AND status != SCHEDULED")
    // List<AppointmentEntity> getInterviewerPastMeetings(long interviewerId);
    
    // @Query(value = "SELECT * FROM appointment WHERE interviewerId=?1 AND (status = PENDING OR status = SCHEDULED)")
    // List<AppointmentEntity> getInterviewerFutMeetings(long interviewerId);
}
