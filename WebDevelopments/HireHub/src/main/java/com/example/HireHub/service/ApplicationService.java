package com.example.HireHub.service;

import com.example.HireHub.dto.ApplicantResponse;
import com.example.HireHub.dto.ApplicationResponse;
import com.example.HireHub.dto.ApplyJobRequest;
import com.example.HireHub.entity.*;
import com.example.HireHub.entity.Application.Status;
import com.example.HireHub.repositories.*;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ApplicationService {

    private final ApplicationRepository applicationRepository;
    private final JobRepository jobRepository;
    private final UserRepository userRepository;

    public Application applyToJob(String userEmail, ApplyJobRequest request) {
        User user = userRepository.findByEmail(userEmail)
                .orElseThrow(() -> new RuntimeException("User not found"));

        Job job = jobRepository.findById(request.getJobId())
                .orElseThrow(() -> new RuntimeException("Job not found"));

        boolean alreadyApplied = applicationRepository.existsByUserAndJob(user, job);
        if (alreadyApplied) {
            throw new RuntimeException("You already applied to this job");
        }

        Application application = Application.builder()
                .user(user)
                .job(job)
                .coverLetter(request.getCoverLetter())
                .resumeUrl(request.getResumeUrl())
                .expectedSalary(request.getExpectedSalary())
                .status(Status.PENDING)
                .appliedDate(LocalDate.now())
                .build();

        return applicationRepository.save(application);
    }

    public List<Application> getApplicationsForUser(String email) {
        User user = userRepository.findByEmail(email)
                .orElseThrow(() -> new RuntimeException("User not found"));

        return applicationRepository.findByUser(user);
    }

    public List<Application> getApplicationsForJob(String companyEmail, Long jobId) {
        Job job = jobRepository.findById(jobId)
                .orElseThrow(() -> new RuntimeException("Job not found"));

        if (!job.getCompany().getEmail().equals(companyEmail)) {
            throw new RuntimeException("Unauthorized to view applicants for this job");
        }

        return applicationRepository.findByJob(job);
    }

    public Application updateApplicationStatus(Long applicationId, Application.Status status, String companyEmail) {
        Application application = applicationRepository.findById(applicationId)
                .orElseThrow(() -> new RuntimeException("Application not found"));

        Job job = application.getJob();
        if (!job.getCompany().getEmail().equals(companyEmail)) {
            throw new RuntimeException("Unauthorized: You can only update applications for your own jobs");
        }

        application.setStatus(status);
        return applicationRepository.save(application);
    }

    public List<Application> getApplicationsForJob(Long jobId, String companyEmail) {
        Job job = jobRepository.findById(jobId)
                .orElseThrow(() -> new RuntimeException("Job not found"));

        if (!job.getCompany().getEmail().equals(companyEmail)) {
            throw new RuntimeException("Unauthorized: You can only view applications for your own jobs");
        }

        return applicationRepository.findByJobId(jobId);
    }

    public List<Application> getApplicationsForCompany(String companyEmail) {
        List<Job> jobs = jobRepository.findByCompanyEmail(companyEmail);
        return applicationRepository.findByJobIn(jobs);
    }

    public List<ApplicationResponse> getUserApplications(String userEmail) {
        User user = userRepository.findByEmail(userEmail)
                .orElseThrow(() -> new RuntimeException("User not found"));

        return applicationRepository.findByUser(user).stream().map(application -> {
            ApplicationResponse dto = new ApplicationResponse();
            dto.setJobId(application.getJob().getId());
            dto.setTitle(application.getJob().getTitle());
            dto.setCompanyName(application.getJob().getCompany().getName());
            dto.setStatus(application.getStatus().name()); // assuming enum
            dto.setAppliedDate(application.getAppliedDate());
            return dto;
        }).toList();
    }

    public List<ApplicantResponse> getApplicantsForJob(String companyEmail, Long jobId) {
        Job job = jobRepository.findById(jobId)
                .orElseThrow(() -> new RuntimeException("Job not found"));

        if (!job.getCompany().getEmail().equals(companyEmail)) {
            throw new RuntimeException("Unauthorized: This job does not belong to your company");
        }

        return applicationRepository.findByJob(job).stream().map(application -> {
            ApplicantResponse dto = new ApplicantResponse();
            dto.setName(application.getUser().getName());
            dto.setEmail(application.getUser().getEmail());
            dto.setResumeUrl(application.getResumeUrl());
            dto.setCoverLetter(application.getCoverLetter());
            dto.setExpectedSalary(application.getExpectedSalary());
            dto.setStatus(application.getStatus().name()); // if enum
            return dto;
        }).toList();
    }

}
