package com.example.demo.service;

import com.example.demo.domains.Task;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface TaskService {

    public Task addTask(Task task);
    public Task getTaskById(Long taskId);
    public boolean getStatus(Long taskId);
    public Task updateStatus(Long id);
    public Integer deleteTask(Long  id);
    public List<Task> getAllTasks();




}
