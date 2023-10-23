package com.todolistBackend.todolistBackend;

import com.todolistBackend.todolistBackend.dao.TaskRepository;
import com.todolistBackend.todolistBackend.model.Task;
import com.todolistBackend.todolistBackend.service.TaskService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;

@SpringBootTest
class TodolistBackendApplicationTests {

	@Test
	void contextLoads() {
	}

	@InjectMocks
	private TaskService taskService;

	@Mock
	private TaskRepository taskRepository;

	@BeforeEach
	public void setUp() {
		taskService = new TaskService(taskRepository);
	}

	@Test
	public void testGetAllTasks() {
		List<Task> tasks = List.of(
				new Task(1L, "Task 1", "Description 1", false),
				new Task(2L, "Task 2", "Description 2", true)
		);
		when(taskRepository.findAll()).thenReturn(tasks);
		List<Task> retrievedTasks = taskService.getAllTasks();
		assertEquals(2, retrievedTasks.size());
	}

	@Test
	public void testGetTaskById() {
		Task task = new Task(1L, "Task 1", "Description 1", false);
		when(taskRepository.findById(1L)).thenReturn(Optional.of(task));
		Task retrievedTask = taskService.getTaskById(1L);
		assertNotNull(retrievedTask);
		assertEquals("Task 1", retrievedTask.getTitle());
	}

	@Test
	public void testCreateTask() {
		Task newTask = new Task(null, "New Task", "New Description", false);
		Task savedTask = new Task(1L, "New Task", "New Description", false);
		when(taskRepository.save(newTask)).thenReturn(savedTask);
		Task createdTask = taskService.createTask(newTask);
		assertNotNull(createdTask);
		assertEquals(1L, createdTask.getId());
	}

	@Test
	public void testUpdateTask() {
		Task updatedTask = new Task(1L, "Updated Task", "Updated Description", true);
		when(taskRepository.save(updatedTask)).thenReturn(updatedTask);
		Task result = taskService.updateTask(1L, updatedTask);
		assertNotNull(result);
		assertEquals("Updated Task", result.getTitle());
		assertTrue(result.isCompleted());
	}

	@Test
	public void testDeleteTask() {
		doNothing().when(taskRepository).deleteById(1L);
		taskService.deleteTask(1L);
	}
}
