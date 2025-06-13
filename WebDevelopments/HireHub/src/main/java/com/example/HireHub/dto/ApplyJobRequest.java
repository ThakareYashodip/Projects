package com.example.HireHub.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class ApplyJobRequest {

    @NotNull
    private Long jobId;

    @NotBlank
    private String coverLetter;

    @NotBlank
    private String resumeUrl;

    @NotNull
    private Double expectedSalary;
}
