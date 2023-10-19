package com.example.todolist3;

import org.springframework.data.repository.CrudRepository;

public interface TodoItemRepository  extends CrudRepository<TodoItem, Long> {
}
