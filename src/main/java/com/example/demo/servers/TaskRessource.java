package com.example.demo.servers;

import com.example.demo.domains.Task;
import com.example.demo.service.TaskService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@Slf4j
@RestController
@RequestMapping(value = "/v1/api/task", produces = "application/json", consumes = "application/json")

public class TaskRessource {

    @Autowired
    TaskService taskService;

    @PostMapping("/save")
    public Task addTask(@RequestBody Task task) {

        return taskService.addTask(task);

    }

    @PostMapping("/getById")
    public Task getTaskById(Long taskId) {
        return taskService.getTaskById(taskId);
    }

    @PostMapping("/status")
    public boolean getStatus(Long taskId) {
        return taskService.getStatus(taskId);
    }

    @PostMapping("/updateStatus")
    public Task updateStatus(Long id) {
        return taskService.updateStatus(id);
    }

    @PostMapping("/delete")
    public Integer deleteTask (Long id) {
        return taskService.deleteTask(id);
    }

    @PostMapping("/getAll")
    public List<Task> getAllTasks () {
        return taskService.getAllTasks();
    }

}
