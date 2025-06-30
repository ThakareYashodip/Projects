package com.example.UrbanServe.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

// ComplaintCreateRequestDTO.java
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ComplaintCreateRequestDTO {
    private ComplaintDTO complaint;
    private Long userId;
}
