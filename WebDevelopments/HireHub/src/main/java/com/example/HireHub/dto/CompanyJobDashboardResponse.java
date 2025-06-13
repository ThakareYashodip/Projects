package com.example.HireHub.dto;

import lombok.Data;

@Data
public class CompanyJobDashboardResponse {
    private Long jobId;
    private String title;
    private String location;
    private String type;
    private long totalApplicants;
}
