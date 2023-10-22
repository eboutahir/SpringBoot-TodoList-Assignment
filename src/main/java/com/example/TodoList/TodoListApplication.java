package com.example.TodoList;

import com.example.TodoList.model.Task;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import com.example.TodoList.service.TaskService;

@SpringBootApplication
@AllArgsConstructor
public class TodoListApplication{

	public static void main(String[] args) {
		SpringApplication.run(TodoListApplication.class, args);
	}

}
