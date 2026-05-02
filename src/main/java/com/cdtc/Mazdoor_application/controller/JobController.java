package com.cdtc.Mazdoor_application.controller;

import com.cdtc.Mazdoor_application.dto.ApiResponse;
import com.cdtc.Mazdoor_application.dto.JobPostRequest;
import com.cdtc.Mazdoor_application.model.Job;
import com.cdtc.Mazdoor_application.service.JobService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/jobs")
public class JobController {

    @Autowired
    private JobService jobService;

    /**
     * API to Post a new Job
     * POST /api/v1/jobs
     */
    @PostMapping("/jobPosting")
    public ResponseEntity<Job> createJob(
            @Valid @RequestBody JobPostRequest request,
            @RequestHeader(value = "Authorization", required = false) String token) {

        // In a real application, you extract the Employer ID from the JWT token.
        // String employerId = jwtUtil.extractUserId(token);
        String employerId = "emp_999";

        // Call Service
        Job createdJob = jobService.createJobPost(employerId, request);

        // Return 201 Created Status with the Job object directly
        return ResponseEntity.status(HttpStatus.CREATED).body(createdJob);
    }

    @GetMapping("/skill/{skillName}")
    public ResponseEntity<List<Job>> getJobsBySkill(@PathVariable String skillName) {

        List<Job> jobs = jobService.getJobsBySkill(skillName);

        // Optional best practice: Return 204 No Content if the list is empty
        if (jobs.isEmpty()) {
            return ResponseEntity.noContent().build();
        }

        // Return 200 OK with the list of jobs
        return ResponseEntity.ok(jobs);
    }
}
