package com.example.HireHub.dto;

import com.example.HireHub.entity.Application.Status;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class UpdateApplicationStatusRequest {
    @NotNull
    private Status status;
}
