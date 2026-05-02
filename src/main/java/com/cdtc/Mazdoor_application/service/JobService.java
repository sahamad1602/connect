package com.cdtc.Mazdoor_application.service;

import com.cdtc.Mazdoor_application.dto.JobPostRequest;
import com.cdtc.Mazdoor_application.model.Job;
import com.cdtc.Mazdoor_application.repository.JobRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JobService {

    @Autowired
    private JobRepository jobRepository;

    public Job createJobPost(String employerId, JobPostRequest request) {

        // 1. Map the DTO data to the Database Entity
        Job newJob = new Job();
        newJob.setEmployerId(employerId);
        newJob.setTitle(request.getTitle());
        newJob.setDescription(request.getDescription());
        newJob.setRequiredSkill(request.getRequiredSkill());
        newJob.setNumberOfWorkersRequired(request.getNumberOfWorkersRequired());
        newJob.setDailyWage(request.getDailyWage());
        newJob.setJobDate(request.getJobDate());
        newJob.setLocationAddress(request.getLocationAddress());
        newJob.setLatitude(request.getLatitude());
        newJob.setLongitude(request.getLongitude());

        // 2. Save to Database
        return jobRepository.save(newJob);
    }

    // NEW METHOD
    public List<Job> getJobsBySkill(String skillName) {
        return jobRepository.findByRequiredSkill(skillName);
    }
}
