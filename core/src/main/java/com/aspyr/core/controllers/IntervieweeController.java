package com.aspyr.core.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.aspyr.core.dao.PastMeetings;
import com.aspyr.core.entities.Interviewee;
import com.aspyr.core.services.IntervieweeServices;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
public class IntervieweeController {
    @Autowired
    IntervieweeServices intervieweeServices;

    // Create a new user
    @PostMapping("/interviewee")
    public Interviewee createUser(@RequestBody Interviewee interviewee) {
        return intervieweeServices.createUser(interviewee);
    }

    // Get all users
    @GetMapping("/interviewee")
    public List<Interviewee> getAllUsers() {
        return intervieweeServices.getAllUsers();
    }
    
    // Get user by ID
    @GetMapping("/interviewee/{id}")
    public Optional<Interviewee> getUserById(@PathVariable Long id) {
        return intervieweeServices.getUserById(id);
    }

    // Get past meetings by intervieweeId
    // @GetMapping("/interviewee/pastmeetings/{id}")
    // public List<PastMeetings> getIntervieweePastMeetings(@PathVariable Long id) {
    //     return intervieweeServices.getIntervieweePastMeetings(id);
    // }
     
}
