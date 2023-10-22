package com.example.demo.serviceImpl;


import com.example.demo.domains.Task;
import com.example.demo.repository.TaskRepository;
import com.example.demo.service.TaskService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Slf4j
@Service
public class serviceImpl implements TaskService {

    @Autowired
    private TaskService taskService;

    @Autowired
    private TaskRepository taskRepository;

    @Override
    public Task addTask(Task task) {

        return taskRepository.save(task);

    }

    @Override
    public Task getTaskById(Long taskId) {
        return taskRepository.getTaskById(taskId);
    }

    @Override
    public boolean getStatus(Long taskId) {
        return taskRepository.getStatus(taskId);
    }

    @Override
    public Task updateStatus(Long id) {
        Optional<Task> task = taskRepository.getOpTaskById(id);
        Task T = null;
        if (task.isPresent()) {
            Task task1 = task.get();
            task1.setCompleted(task.get().isCompleted());
            T = taskRepository.save(task1);


        }
        return T;
    }

        @Override
        public Integer deleteTask (Long id) {
            return taskRepository.deleteTaskById(id);
        }

        @Override
        public List<Task> getAllTasks () {
            return taskRepository.getAll();
        }
    }
