package com.example.taskFlow.dto;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TaskDTO {
    @Id
    @GeneratedValue (strategy = GenerationType.AUTO)
    private Long id;

    @NotBlank(message = "Title is required.")
    @Size(min = 3,max =50,message = "Title must be at least 3 chararcters.")
    private String title;

    @Size(max=200,message = "Desciption must not be exceed 200 characters.")
    private String description;
    private boolean completed;
    private LocalDateTime dueDateTime;
}
