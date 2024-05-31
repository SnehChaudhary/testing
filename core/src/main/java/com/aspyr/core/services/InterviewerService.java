package com.aspyr.core.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aspyr.core.entities.Interviewer;
import com.aspyr.core.repository.InterviewerRepository;

@Service
public class InterviewerService {
    
    @Autowired
   InterviewerRepository interviewerRepository;

        public InterviewerService(InterviewerRepository interviewerRepository) {
        this.interviewerRepository = interviewerRepository;
    }
    
    // Create a new user
    public Interviewer createUser(Interviewer interviewer) {
        return interviewerRepository.save(interviewer);
    }
    // Get all users
    public List<Interviewer> getAllUsers() {
        System.out.println("All users Hit!");
        return interviewerRepository.findAll();
    }

    // Get user by ID
    public Optional<Interviewer> getUserById(Long id) {
        return interviewerRepository.findById(id);
    }

}
