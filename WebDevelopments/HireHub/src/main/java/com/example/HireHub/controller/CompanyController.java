package com.example.HireHub.controller;

import com.example.HireHub.dto.CompanyJobDashboardResponse;
import com.example.HireHub.entity.Application;
import com.example.HireHub.entity.Job;
import com.example.HireHub.repositories.*;
import com.example.HireHub.service.JobService;
import com.example.HireHub.entity.Company;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/company")
@RequiredArgsConstructor
public class CompanyController {

    private final CompanyRepository companyRepository;
    private final JobRepository jobRepository;
    private final ApplicationRepository applicationRepository;
    private final JobService jobService;

    @GetMapping("/jobs")
    public ResponseEntity<List<Job>> getMyJobs(@AuthenticationPrincipal UserDetails userDetails) {
        String email = userDetails.getUsername();
        Company company = companyRepository.findByEmail(email)
                .orElseThrow(() -> new RuntimeException("Company not found"));

        List<Job> jobs = jobRepository.findByCompany(company);
        return ResponseEntity.ok(jobs);
    }

    @GetMapping("/jobs/{jobId}/applications")
    public ResponseEntity<List<Application>> getApplicationsForJob(
            @PathVariable Long jobId,
            @AuthenticationPrincipal UserDetails userDetails) {

        String email = userDetails.getUsername();
        Company company = companyRepository.findByEmail(email)
                .orElseThrow(() -> new RuntimeException("Company not found"));

        Job job = jobRepository.findById(jobId)
                .orElseThrow(() -> new RuntimeException("Job not found"));

        if (!job.getCompany().getId().equals(company.getId())) {
            return ResponseEntity.status(403).build(); // Forbidden
        }

        List<Application> applications = applicationRepository.findByJob(job);
        return ResponseEntity.ok(applications);
    }

    @GetMapping("/dashboard")
    public ResponseEntity<List<CompanyJobDashboardResponse>> getDashboard(
            @AuthenticationPrincipal UserDetails userDetails) {

        List<CompanyJobDashboardResponse> dashboard = jobService.getCompanyJobDashboard(userDetails.getUsername());
        return ResponseEntity.ok(dashboard);
    }
    
}
