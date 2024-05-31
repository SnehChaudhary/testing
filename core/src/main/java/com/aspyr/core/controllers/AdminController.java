package com.aspyr.core.controllers;

import org.springframework.web.bind.annotation.RestController;

import com.aspyr.core.dao.InterviewRequestDAO;
import com.aspyr.core.services.InterviewRequestService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
public class AdminController {

    @Autowired
    InterviewRequestService interviewRequestService;

    @PostMapping("/interview")
    public String getMethodName(
        @RequestBody InterviewRequestDAO interviewRequestDAO  
    )
    {
        interviewRequestService.bookInterview(interviewRequestDAO);
        return "Interview Request Success!!";
    }
      
}