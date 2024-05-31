package com.aspyr.core.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.aspyr.core.entities.Interviewee;
@Repository
public interface IntervieweeRepository extends JpaRepository<Interviewee,Long>{
    
}
