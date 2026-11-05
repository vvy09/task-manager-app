package com.application.taskmanager.service;

import com.application.taskmanager.dto.TaskRequestDto;
import com.application.taskmanager.dto.TaskResponseDto;
import com.application.taskmanager.entity.Task;
import com.application.taskmanager.repository.TaskRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class TaskService {

    private static final Logger log =
            LoggerFactory.getLogger(TaskService.class);

    private final TaskRepository taskRepository;

    public TaskService(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    public TaskResponseDto saveTask(TaskRequestDto request) {

        Task task = new Task();

        task.setTitle(request.getTitle());
        task.setDescription(request.getDescription());
        task.setCreatedAt(LocalDateTime.now());

        Task savedTask = taskRepository.save(task);
        log.info("Task created successfully with ID: {}", savedTask.getId());

        return convertToResponse(savedTask);
    }

    public List<TaskResponseDto> getAllTasks() {

        log.info("Fetching all tasks");
        return taskRepository.findAll()
                .stream()
                .map(this::convertToResponse)
                .toList();
    }

    private TaskResponseDto convertToResponse(Task task) {

        return new TaskResponseDto(
                task.getId(),
                task.getTitle(),
                task.getDescription(),
                task.getCreatedAt()
        );
    }
}
