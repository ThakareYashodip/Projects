package com.example.taskFlow.controller;

import com.example.taskFlow.config.ApiResponse;
import com.example.taskFlow.dto.TaskDTO;
import com.example.taskFlow.entity.Task;
import com.example.taskFlow.mapper.TaskMapper;
import com.example.taskFlow.service.TaskService;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/tasks")
@CrossOrigin(origins = "*")
@Tag(name = "Tasks",description = "Operations related to tasks.")
public class TaskController {

    @Autowired
    private TaskService taskService;

    // Create Task - Return 201 Created
    @PostMapping
    public ResponseEntity<?> createTask(@Valid @RequestBody TaskDTO taskDTO) {
        try {
            Task task = TaskMapper.toEntity(taskDTO);
            Task createdTask = taskService.createTask(task);
            TaskDTO responseDTO = TaskMapper.toDTO(createdTask);
            ApiResponse<TaskDTO> apiResponse = new ApiResponse<>(
                    true,"Task Created.",responseDTO
            );
            return ResponseEntity.status(HttpStatus.CREATED).body(apiResponse);
//                    .created(URI.create("/api/tasks/" + createdTask.getId()))
//                    .body(responseDTO);
        } catch (Exception e) {
            return ResponseEntity.internalServerError().body("Failed to create task.");
        }
    }

    // Get All Tasks
    @GetMapping("/all")
    public ResponseEntity<ApiResponse<List<TaskDTO>>> getAllTasks() {
        List<TaskDTO> taskDTOs = taskService.getAllTask()
                .stream()
                .map(TaskMapper::toDTO)
                .collect(Collectors.toList());
        ApiResponse<List<TaskDTO>> apiResponse = new ApiResponse<List<TaskDTO>>(true,"Tasks Fetched",taskDTOs);
        return ResponseEntity.status(HttpStatus.OK).body(apiResponse);
    }

    // Get Task by ID
    @GetMapping("/{id}")
    public ResponseEntity<?> getTaskById(@PathVariable Long id) {
        Optional<Task> task = taskService.getTaskById(id);
        return task.map(value -> ResponseEntity.ok(TaskMapper.toDTO(value)))
                .orElseThrow(()-> new RuntimeException("Task not found.."));
    }

    // Update Task
    @PutMapping("/{id}")
    public ResponseEntity<?> updateTask(@Valid @PathVariable Long id, @RequestBody TaskDTO taskDTO) {
        Optional<Task> existingTask = taskService.getTaskById(id);
        if (existingTask.isEmpty()) {
            return ResponseEntity.status(404).body("Task with ID " + id + " not found.");
        }

        Task updated = taskService.updateTask(id, TaskMapper.toEntity(taskDTO));
        return ResponseEntity.ok(TaskMapper.toDTO(updated));
    }

    // Delete Task
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteTask(@PathVariable Long id) {
        Optional<Task> existingTask = taskService.getTaskById(id);
        if (existingTask.isEmpty()) {
            return ResponseEntity.status(404).body("Task with ID " + id + " not found.");
        }

        taskService.deleteTask(id);
        return ResponseEntity.ok("Task with ID " + id + " deleted successfully.");
    }

    @GetMapping("/paged")
    public ResponseEntity<?> getAllTasksPaged(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "5") int size,
            @RequestParam(defaultValue = "id") String sortBy,
            @RequestParam(defaultValue = "asc") String sortDir
    ) {
        Page<Task> taskPage = taskService.getAllTasksPaged(page, size, sortBy, sortDir);
        return ResponseEntity.ok(taskPage);
    }

}
