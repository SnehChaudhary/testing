package com.aspyr.core.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aspyr.core.dao.InterviewRequestDAO;
import com.aspyr.core.entities.AppointmentEntity;
import com.aspyr.core.entities.InterviewRequestLogEntity;
import com.aspyr.core.repository.AppointmentRepository;
import com.aspyr.core.repository.InterviewBookingRepository;

@Service
public class InterviewRequestService {

    @Autowired
    InterviewBookingRepository interviewBookingRepository;
    @Autowired
    AppointmentRepository appointmentRepository;

    public void bookInterview(InterviewRequestDAO interviewRequestDAO) {

        AppointmentEntity appointmentEntity = new AppointmentEntity();

        appointmentEntity.setIntervieweeId(interviewRequestDAO.getIntervieweeId());
        appointmentEntity.setReqStartTime(interviewRequestDAO.getStartTime());
        appointmentEntity.setReqEndTime(interviewRequestDAO.getEndTime());
        appointmentEntity.setDate(interviewRequestDAO.getDate());
        appointmentEntity.setRoundType(interviewRequestDAO.getRoundType());

        try {
            Optional<InterviewRequestLogEntity> entryCheck = interviewBookingRepository
                    .findRequest(interviewRequestDAO.getStartTime(),interviewRequestDAO.getDate());

            if (!entryCheck.isPresent()) {
                InterviewRequestLogEntity interviewRequestEntity = new InterviewRequestLogEntity();

                interviewRequestEntity.setRoundType(interviewRequestDAO.getRoundType());
                interviewRequestEntity.setStartTime(interviewRequestDAO.getStartTime());
                interviewRequestEntity.setEndTime(interviewRequestDAO.getEndTime());
                interviewRequestEntity.setDate(interviewRequestDAO.getDate());
                interviewRequestEntity.setRecordCount(1l);

                interviewBookingRepository.save(interviewRequestEntity);
            } else {
                interviewBookingRepository.updateCount(entryCheck.get().getId());
            }

            appointmentRepository.save(appointmentEntity);
        } catch (Exception e) {
            System.out.println("DB Error");

            e.printStackTrace();
        }
    }
}
