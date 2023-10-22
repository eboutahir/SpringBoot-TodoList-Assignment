package com.todolist.demo.servise;

import com.todolist.demo.model.TodoEntity;
import com.todolist.demo.repository.TodoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service

public class TodoService {
    private TodoRepository todoRepository;
    @Autowired
    public TodoService(TodoRepository todoRepository) {
        this.todoRepository = todoRepository;
    }
    public List<TodoEntity> recuperer()
    {
        return todoRepository.findAll();
    }
    public TodoEntity createTodo(TodoEntity t)
    {
        return todoRepository.save(t);
    }
    public TodoEntity chercherParId(Long id)
    {
        return todoRepository.findById(id).orElse(null);
    }
    public TodoEntity modifier(TodoEntity t)
    {
        return todoRepository.save(t);
    }
    public void supprimer(TodoEntity t)
    {
        todoRepository.delete(t);
    }
}
