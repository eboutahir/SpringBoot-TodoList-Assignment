package com.SpringExemple.demo.Services;

import com.SpringExemple.demo.Entities.Todo;
import com.SpringExemple.demo.Repository.TodoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TodoService {
    @Autowired
    private TodoRepository todoRepository;
    public List<Todo> getAllTodos() {
        return todoRepository.findAll();
    }
    public void addTodo(Todo todo) {
        todoRepository.save(todo);
    }
    public void deleteTodoById(Long id) {
        todoRepository.deleteById(id);
    }
    public Todo updateTodo(Todo todo) {
        return todoRepository.save(todo);
    }
}
