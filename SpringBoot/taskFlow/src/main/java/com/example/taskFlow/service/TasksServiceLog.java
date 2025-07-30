package com.example.taskFlow.service;
import com.example.taskFlow.entity.Task;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.logging.Logger;

@Slf4j
@Service
public class TasksServiceLog {

  //  private static final Logger logger = (Logger) LoggerFactory.getLogger(TasksServiceLog.class);

    public Task craeteTask(Task task){
        log.info("Creating Task:{}",task.getTitle());
        return task;
    }
}
