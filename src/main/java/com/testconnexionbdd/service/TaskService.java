package com.testconnexionbdd.service;

import com.testconnexionbdd.model.Task;
import com.testconnexionbdd.repository.TaskRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TaskService {

    private TaskRepository taskRepository;

    public List<Task> getAllTasks(){
        return taskRepository.findAll();
    }

    public Task CreateTask(Task t){
    return taskRepository.save(t);
    }
    public Optional<Task> findTask(Long id){
        return taskRepository.findById(id);
    }
    public void deleteTask(Long id){
        taskRepository.deleteById(id);
    }
    public Task updateTask(Task task) {
        return taskRepository.save(task);
    }
}
