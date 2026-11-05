package com.application.taskmanager;

import com.application.taskmanager.dto.TaskRequestDto;
import com.application.taskmanager.dto.TaskResponseDto;
import com.application.taskmanager.service.TaskService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class TaskmanagerApplicationTests {

	@Autowired
	private TaskService taskService;

	@Test
	void shouldCreateTaskSuccessfully() {

		TaskRequestDto request = new TaskRequestDto();
		request.setTitle("Task 1");
		request.setDescription("Complete task 1");

		TaskResponseDto response = taskService.saveTask(request);

		assertNotNull(response.getId());
		assertEquals("Task 1", response.getTitle());
		assertEquals("Complete task 1",
				response.getDescription());
	}

	@Test
	void shouldRetrieveAllTasks() {

		TaskRequestDto request = new TaskRequestDto();
		request.setTitle("Task 1");

		taskService.saveTask(request);

		List<TaskResponseDto> tasks = taskService.getAllTasks();

		assertFalse(tasks.isEmpty());
		assertTrue(tasks.stream()
				.anyMatch(task -> task.getTitle().equals("Task 1")));
	}

}
