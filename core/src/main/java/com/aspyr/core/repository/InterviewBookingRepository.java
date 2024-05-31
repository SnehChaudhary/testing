package com.aspyr.core.repository;

import org.springframework.stereotype.Repository;

import com.aspyr.core.entities.InterviewRequestLogEntity;

import jakarta.transaction.Transactional;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import java.util.Optional;
import java.time.LocalDate;
import java.time.LocalTime;


@Repository
public interface InterviewBookingRepository extends CrudRepository<InterviewRequestLogEntity,Long>{
    
    @Query(value = "SELECT * FROM interview_request_log irl WHERE irl.start_time = ?1 AND irl.date = ?2",nativeQuery = true)
    Optional<InterviewRequestLogEntity> findRequest(LocalTime startTime,LocalDate date);

    @Modifying
    @Transactional
    @Query(value = "UPDATE interview_request_log SET record_count = record_count+1 WHERE id = ?1",
    nativeQuery = true)
    void updateCount(Long id);
}
