package com.aspyr.core.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import com.aspyr.core.dao.FutMeetings;
import com.aspyr.core.dao.PastMeetings;
import com.aspyr.core.entities.AppointmentEntity;
import com.aspyr.core.entities.Interviewee;
import com.aspyr.core.repository.AppointmentRepository;
import com.aspyr.core.repository.IntervieweeRepository;

import java.util.*;

@Service
public class IntervieweeServices {
    
    @Autowired
   IntervieweeRepository intervieweeRepository;

   @Autowired
   AppointmentRepository appointmentRepository;

    // Create a new user
    public Interviewee createUser(Interviewee interviewee) {
        return intervieweeRepository.save(interviewee);
    }

    // Get all users
    public List<Interviewee> getAllUsers() {
        System.out.println("All users Hit!");
        return intervieweeRepository.findAll();
    }

    // Get user by ID
    public Optional<Interviewee> getUserById(Long id) {
        return intervieweeRepository.findById(id);
    }
    
    // Get past meetings of interviewee by ID
    // public List<PastMeetings> getIntervieweePastMeetings(@PathVariable Long id) {
    //     List<AppointmentEntity> arr = appointmentRepository.getIntervieweePastMeetings(id);
        
    //     List<PastMeetings> ans = new ArrayList<>();
    //     for (AppointmentEntity ae : arr) {
    //         PastMeetings pm = new PastMeetings();
    //         pm.setReqStartTime(ae.getReqStartTime());
    //         pm.setReqEndTime(ae.getReqEndTime());
    //         ans.add(pm);            
    //     }

    //     return ans;
    // }
    
    // // Get Future meetings of interviewee by ID
    // public List<FutMeetings> getIntervieweeFutMeetings(@PathVariable Long id) {
    //     List<AppointmentEntity> arr = appointmentRepository.getIntervieweeFutMeetings(id);
        
    //     List<FutMeetings> ans = new ArrayList<>();
    //     for (AppointmentEntity ae : arr) {
    //         FutMeetings pm = new FutMeetings();
    //         pm.setFeedbackReport(ae.getFeedbackReport());
    //         pm.setFinalRating(ae.getFinalRating());
    //         ans.add(pm);
    //     }

    //     return ans;
    // }
}
