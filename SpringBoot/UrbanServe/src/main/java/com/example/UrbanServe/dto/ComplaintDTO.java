package com.example.UrbanServe.dto;

import com.example.UrbanServe.entity.Complaint.Status;
import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ComplaintDTO {
    private Long id;
    private String title;
    private String description;
    private Status status;
    private LocalDateTime createdAt;
}
