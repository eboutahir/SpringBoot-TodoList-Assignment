package com.example.todotemplate.domain;

import lombok.Data;

@Data
public class Task {
    private Long id;
    private String taskTodo;
    private boolean completed;
}