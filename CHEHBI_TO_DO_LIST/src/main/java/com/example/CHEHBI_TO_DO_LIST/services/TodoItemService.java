package com.example.CHEHBI_TO_DO_LIST.services;

import com.example.CHEHBI_TO_DO_LIST.models.TodoItem;

public interface TodoItemService {

    Iterable<TodoItem> getAllTasks();

    void saveTask(TodoItem todoItem);
    TodoItem findTodoItemById(Long id);
    void deleteTask(TodoItem todoItem);
    void updateCompleteStatus(Long itemId, boolean isComplete);

}
