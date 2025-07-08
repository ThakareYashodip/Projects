package com.example.UrbanServe.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import com.fasterxml.jackson.annotation.JsonProperty;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ComplaintCreateRequestDTO {

    @JsonProperty("complaint")
    private ComplaintDTO complaint;

    @JsonProperty("userId")
    private Long userId;
}

