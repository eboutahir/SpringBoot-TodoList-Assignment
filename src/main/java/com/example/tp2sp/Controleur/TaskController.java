package com.example.tp2sp.Controleur;
import com.example.tp2sp.Service.TaskService;
import com.example.tp2sp.Model.Task;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@Controller
@RequestMapping("/tasks")
public class TaskController {
    private final TaskService taskService;

    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }

    @GetMapping
    public String listTasks(Model model) {
        model.addAttribute("tasks", taskService.getAllTasks());
        return "task/home";
    }
    @GetMapping("/getall")
    public ResponseEntity<List<Task>> getAllTasks() {
        List<Task> tasks = taskService.getAllTasks();
        return new ResponseEntity<>(tasks, HttpStatus.OK);
    }
    @GetMapping("/taskIdg/{taskId}")
    public ResponseEntity<Task> getTaskById(@PathVariable UUID taskId) {
        return taskService.getTaskById(taskId)
                .map(task -> new ResponseEntity<>(task, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @GetMapping("/new")
    public String newTaskForm(Model model) {
        model.addAttribute("task", new Task());

        return "task/home";
    }

    @PostMapping("/enreg")
    public String createTask(@ModelAttribute Task task) {
        taskService.createTask(task);
        return "redirect:/tasks";
    }

    @GetMapping("/{id}/edit")
    public String editTaskForm(@PathVariable UUID id, Model model) {
        Task task = taskService.getTaskById(id).orElse(null);
        if (task != null) {
            model.addAttribute("task", task);

            return "task/home";
        } else {
            return "redirect:/tasks";
        }
    }

    @PutMapping("/{id}/edit")
    public String updateTask(@PathVariable UUID id, @ModelAttribute Task task) {
        Task updatedTask = taskService.updateTask(id, task);
        if (updatedTask != null) {
            return "redirect:/tasks";
        } else {
            return "redirect:/tasks/" + id + "/edit";
        }
    }

    @DeleteMapping ("/{id}/delete")
    public String deleteTask(@PathVariable UUID id) {
        taskService.deleteTask(id);
        return "redirect:/tasks";
    }
}