package com.aspyr.core.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.aspyr.core.entities.Interviewer;
import com.aspyr.core.services.InterviewerService;

@RestController
public class InterviewerController {
    @Autowired
    InterviewerService interviewerServices;

    // Create a new user
    @PostMapping("/interviewer")
    public Interviewer createUser(@RequestBody Interviewer interviewer) {
        return interviewerServices.createUser(interviewer);
    }

    // Get all users
    @GetMapping("/interviewer")
    public List<Interviewer> getAllUsers() {
        return interviewerServices.getAllUsers();
    }
    // Get user by ID
    @GetMapping("/interviewer/{id}")
    public Optional<Interviewer> getUserById(@PathVariable Long id) {
        return interviewerServices.getUserById(id); 
    }
}
