package com.example.HireHub.dto;

import lombok.Data;

@Data
public class ApplicantResponse {
    private String name;
    private String email;
    private String resumeUrl;
    private String coverLetter;
    private Double expectedSalary;
    private String status;
}
