package com.ToTheListe2.To_the_liste.service;

import com.ToTheListe2.To_the_liste.model.Task;
import com.ToTheListe2.To_the_liste.repo.Taskrepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TaskService {

    @Autowired
    private Taskrepo taskRepo;

    public List<Task> getAllTasks() {
        return taskRepo.findAll();
    }

    public Optional<Task> getTaskById(Long id) {
        return taskRepo.findById(id);
    }

    public Task addTask(Task task) {
        return taskRepo.save(task);
    }

    public Task updateTask(Long id, Task task) {
        Optional<Task> taskData = taskRepo.findById(id);
        if (taskData.isPresent()) {
            Task updatedTaskData = taskData.get();
            updatedTaskData.setTitle(task.getTitle());
            updatedTaskData.setDescription(task.getDescription());
            return taskRepo.save(updatedTaskData);
        }
        return null; // ou lancez une exception selon la logique de votre application
    }

    public void deleteTaskById(Long id) {
        taskRepo.deleteById(id);
    }

    public void deleteAllTasks() {
        taskRepo.deleteAll();
    }
}
