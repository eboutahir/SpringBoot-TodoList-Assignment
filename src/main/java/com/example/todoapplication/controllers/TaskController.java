package com.example.todoapplication.controllers;

import com.example.todoapplication.services.TaskService;
import com.example.todoapplication.models.Task;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.ui.Model;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.util.List;

@Controller
@RequestMapping("api/tasks")
public class TaskController {
    @Autowired
    private TaskService taskService;

    @GetMapping("/")
    public String getAllTasks(Model model) {

        List<Task> tasks = taskService.getAllTask();
        model.addAttribute("tasks", tasks);
        long completedTaskCount = getCompletedTasks();
        model.addAttribute("completedTaskCount", completedTaskCount);
        long incompletedTaskCount=getInCompletedTasks();
        model.addAttribute("incompleteTaskCount",incompletedTaskCount);
        long totalTaskCount = tasks.size();
        model.addAttribute("totalTaskCount", totalTaskCount);
        return "listtask";
    }
    @GetMapping("/edit/{id}")
    public String editTask(@PathVariable Long id, Model model) {
        Task task = taskService.findTaskById(id);
        model.addAttribute("task", task);
        return "editTask";
    }
    @GetMapping("/completed")
    public Long getCompletedTasks() {
        List<Task> completedTasks = taskService.findAllCompleted();
       return completedTasks.stream().count();
    }
    @GetMapping("/incompleted")
    public Long getInCompletedTasks() {
        List<Task> incompletedTasks = taskService.findAllInCompleted();
        return incompletedTasks.stream().count();
    }
    @PostMapping("/")
    public String createTask(@RequestParam("newTask") String newTask) {
        Task task = new Task(newTask, false);
        Task createdTask = taskService.createTask(task);
        return "redirect:/api/tasks/";
    }
    @PostMapping("/{id}")
    public String updateTask(@PathVariable Long id, @RequestParam(name = "completed", required = false) Boolean completed) {
        Task task = taskService.findTaskById(id);
        if (task == null) {
            return "redirect:/api/tasks/";
        }
        if (completed != null) {
            task.setCompleted(completed);
            taskService.updateTask(task);
        }
        return "redirect:/api/tasks/";
    }

    @PutMapping("/{id}")
    public ResponseEntity<Task> updateTask(@PathVariable Long id, @RequestBody Task task) {
        task.setId(id);
        return ResponseEntity.ok(taskService.updateTask(task));
    }
    @PostMapping("/edit/{id}")
    public String updateTask(@PathVariable Long id, @RequestParam("editedTask") String editedTask) {
        Task task = taskService.findTaskById(id);
        if (task != null) {
            task.setTask(editedTask);
            taskService.updateTask(task);
        }
        return "redirect:/api/tasks/";
    }
    @PostMapping("/delete/{id}")
    public String deleteTask(@PathVariable Long id) {
        taskService.deleteTask(id);
        return "redirect:/api/tasks/";
    }
}
