package com.example.todotemplate.Controller;

import com.example.todotemplate.domain.Task;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Controller
@RequestMapping("/tasks")

public class TaskController {
    @Autowired
    private RestTemplate restTemplate;

    @GetMapping
    public String viewTasks(Model model) {
        List<Task> tasks = restTemplate.exchange(
                "http://localhost:8080/v1/api/task/getAll",
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<List<Task>>() {}).getBody();
        model.addAttribute("tasks", tasks);
        return "tasks";
    }

    @GetMapping("/create")
    public String createTaskForm(Model model) {
        model.addAttribute("task", new Task());
        return "createTask";
    }

    @PostMapping("/create")
    public String createTask(@RequestParam("newTask") String newTask) {
        // Set the "title" in the Task object
        Task task = new Task();
        task.setTaskTodo(newTask);
        task.setCompleted(false);

        restTemplate.postForObject("http://localhost:8080/v1/api/task/save", task, Task.class);
        return "redirect:/tasks";
    }


    @GetMapping("/update/{id}")
    public String updateTaskForm(@PathVariable Long id, Model model) {
        Task task = restTemplate.getForObject("http://localhost:8080/todo/tasks/" + id, Task.class);
        model.addAttribute("task", task);
        return "updateTask";
    }



}