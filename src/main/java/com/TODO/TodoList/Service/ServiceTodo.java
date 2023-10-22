package com.TODO.TodoList.Service;

import com.TODO.TodoList.Models.Todo;
import com.TODO.TodoList.Repository.RepositoryTodo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServiceTodo {
    @Autowired
    private RepositoryTodo repositoryTodo;
    public List<Todo> getAllTodo() {

        return repositoryTodo.findAll();
    }

    public Todo createTodo(Todo todo) {
        return repositoryTodo.save(todo);
    }

    public Todo getTodoById(Long id) {

        return repositoryTodo.findById(id).orElse(null);
    }

    public Todo updateTodo(Long id, Todo updatedTodo) {
        Todo existingTodo = repositoryTodo.findById(id).orElse(null);
        if (existingTodo != null) {
            existingTodo.setTitle(updatedTodo.getTitle());
            existingTodo.setCompleted(updatedTodo.isCompleted());
            existingTodo.setDate(updatedTodo.getDate());
            existingTodo.setDescription(updatedTodo.getDescription());
            return repositoryTodo.save(existingTodo);
        }
        return null;
    }

    public boolean deleteTodo(Long id) {
            repositoryTodo.deleteById(id);
            return true;

    }
}
