package com.todolistBackend.todolistBackend;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication
public class TodolistBackendApplication {
	public static void main(String[] args) {
		SpringApplication.run(TodolistBackendApplication.class, args);
	}
}
