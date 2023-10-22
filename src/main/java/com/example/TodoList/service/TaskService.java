package com.example.TodoList.service;

import com.example.TodoList.model.Task;
import com.example.TodoList.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;

@Service
public class TaskService {
    @Autowired
    private TaskRepository taskRepository;

    public List<Task> getAllTask(){
        return taskRepository.findAll();
    }

    public Task createTask(Task task){
        return taskRepository.save(task);
    }

    public boolean deleteTaskItem(Long id){
        taskRepository.deleteById(id);

        if(taskRepository.findById(id) == null ){
            return true;
        }
        return false;
    }

    public Task getTaskById(Long id){
        return taskRepository.findById(id).get();
    }

    public boolean updateStatus(Long id){

        Task task = getTaskById(id);
        task.setStatus("completd");
        taskRepository.save(task);

        if(taskRepository.findById(id) != null){
            return true;
        }
        return false;
    }


















}
