package com.application.taskmanager.controller;

import com.application.taskmanager.dto.TaskRequestDto;
import com.application.taskmanager.dto.TaskResponseDto;
import com.application.taskmanager.service.TaskService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/tasks")
@CrossOrigin(origins = "http://localhost:4200")
public class TaskController {

    private final TaskService taskService;

    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }

    @PostMapping
    public ResponseEntity<TaskResponseDto> createTask(
            @Valid @RequestBody TaskRequestDto request) {

        TaskResponseDto response = taskService.saveTask(request);

        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @GetMapping
    public ResponseEntity<List<TaskResponseDto>> getAllTasks() {

        List<TaskResponseDto> tasks = taskService.getAllTasks();

        return ResponseEntity.ok(tasks);
    }
}
