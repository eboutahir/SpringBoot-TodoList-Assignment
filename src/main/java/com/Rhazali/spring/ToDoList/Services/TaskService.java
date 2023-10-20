package com.Rhazali.spring.ToDoList.Services;

import com.Rhazali.spring.ToDoList.Entities.Task;
import com.Rhazali.spring.ToDoList.Repositories.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskService {
    @Autowired
    private TaskRepository taskRepository;

    public List<Task> getAllTasks(String keyword) {
        if (keyword == null) {
            return taskRepository.findAll();
        } else {
            return taskRepository.findByTitleContainingIgnoreCase(keyword);
        }
    }

    public Task getTaskById(Integer id) {
        return taskRepository.findById(id).orElse(null);
    }

    public void saveTask(Task task) {
        taskRepository.save(task);
    }

    public void deleteTask(Integer id) {
        taskRepository.deleteById(id);
    }

    public void updateTaskPublishedStatus(Integer id, boolean published) {
        // Implement the logic to update the published status
    }
}
