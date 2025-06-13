package com.example.HireHub.controller;

import com.example.HireHub.dto.ApplicantResponse;
import com.example.HireHub.dto.ApplyJobRequest;
import com.example.HireHub.dto.UpdateApplicationStatusRequest;
import com.example.HireHub.entity.Application;
import com.example.HireHub.service.ApplicationService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/applications")
@RequiredArgsConstructor
public class ApplicationController {

    private final ApplicationService applicationService;

    @PostMapping
    public ResponseEntity<Application> applyToJob(@RequestBody @Valid ApplyJobRequest request,
            @AuthenticationPrincipal UserDetails userDetails) {
        String email = userDetails.getUsername();
        Application application = applicationService.applyToJob(email, request);
        return ResponseEntity.ok(application);
    }

    @GetMapping("/mine")
    public ResponseEntity<List<Application>> getMyApplications(@AuthenticationPrincipal UserDetails userDetails) {
        String email = userDetails.getUsername();
        List<Application> applications = applicationService.getApplicationsForUser(email);
        return ResponseEntity.ok(applications);
    }

    @GetMapping("/job/{jobId}")
    public ResponseEntity<List<Application>> getApplicationsForJob(@PathVariable Long jobId,
            @AuthenticationPrincipal UserDetails userDetails) {
        String email = userDetails.getUsername();
        List<Application> applications = applicationService.getApplicationsForJob(email, jobId);
        return ResponseEntity.ok(applications);
    }

    @PatchMapping("/{id}/status")
    public ResponseEntity<Application> updateStatus(@PathVariable Long id,
            @RequestBody @Valid UpdateApplicationStatusRequest request,
            @AuthenticationPrincipal UserDetails userDetails) {

        Application application = applicationService.updateApplicationStatus(id, request.getStatus(),
                userDetails.getUsername());
        return ResponseEntity.ok(application);
    }

    @GetMapping("/company")
    @PreAuthorize("hasAuthority('COMPANY')")
    public ResponseEntity<List<Application>> getCompanyApplications(@AuthenticationPrincipal UserDetails userDetails) {
        List<Application> apps = applicationService.getApplicationsForCompany(userDetails.getUsername());
        return ResponseEntity.ok(apps);
    }


}
