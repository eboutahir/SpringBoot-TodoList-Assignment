package com.example.todoapplication.services;

import com.example.todoapplication.models.Task;
import com.example.todoapplication.repositories.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service

public class TaskService {
@Autowired
    private TaskRepository taskRepository;
    public Task createTask(Task task){
        return taskRepository.save(task);
    }
    public List<Task> getAllTask()
    {
        return taskRepository.findAll();
    }

    /* public Todo findTaskbyId(@PathVariable  Long id)
     {
         return taskRepository.findById(id);
     }*/
    public Task findTaskById(Long id) {
        return taskRepository.getById(id);
    }

    public List<Task> findAllCompleted()
    {
        return taskRepository.findByCompletedTrue();
    }
    public List<Task> findAllInCompleted()
    {
        return taskRepository.findByCompletedFalse();
    }
    public void deleteTask(Long id)
    {
        taskRepository.deleteById(id);
    }
    public Task updateTask(Task task)
    {
        return taskRepository.save(task);
    }

}
