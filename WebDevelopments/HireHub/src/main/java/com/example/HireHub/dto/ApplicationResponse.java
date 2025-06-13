package com.example.HireHub.dto;

import lombok.Data;

import java.time.LocalDate;

@Data
public class ApplicationResponse {
    private Long jobId;
    private String title;
    private String companyName;
    private String status;
    private LocalDate appliedDate;
}
