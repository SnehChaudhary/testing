package com.aspyr.core.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


import com.aspyr.core.entities.Interviewer;

@Repository
public interface InterviewerRepository extends JpaRepository<Interviewer,Long>{

} 