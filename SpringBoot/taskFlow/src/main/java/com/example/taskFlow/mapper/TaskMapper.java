package com.example.taskFlow.mapper;

import com.example.taskFlow.dto.TaskDTO;
import com.example.taskFlow.entity.Task;

public class TaskMapper {

    public static TaskDTO toDTO(Task task){
        TaskDTO taskDTO = new TaskDTO();
        taskDTO.setId(task.getId());
        taskDTO.setDueDateTime(task.getDueDateTime());
        taskDTO.setTitle(task.getTitle());
        taskDTO.setDescription(task.getDescription());
        taskDTO.setCompleted(task.isCompleted());

        return taskDTO;
    }

    public static Task toEntity(TaskDTO taskDTO){
        Task task = new Task();
        task.setTitle(taskDTO.getTitle());
        task.setDescription(taskDTO.getDescription());
        task.setCompleted(taskDTO.isCompleted());
        task.setDueDateTime(taskDTO.getDueDateTime());
        return task;
    }
}
