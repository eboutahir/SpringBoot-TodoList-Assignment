package com.example.tp2sp.Controleur;
import com.example.tp2sp.Service.TaskService;
import com.example.tp2sp.Model.Task;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
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
        return "task/list";
    }

    @GetMapping("/new")
    public String newTaskForm(Model model) {
        model.addAttribute("task", new Task());
        return "task/form";
    }

    @PostMapping("/new")
    public String createTask(@ModelAttribute Task task) {
        taskService.createTask(task);
        return "redirect:/tasks";
    }

    @GetMapping("/{id}/edit")
    public String editTaskForm(@PathVariable UUID id, Model model) {
        Task task = taskService.getTaskById(id).orElse(null);
        if (task != null) {
            model.addAttribute("task", task);
            return "task/form";
        } else {
            return "redirect:/tasks";
        }
    }

    @PostMapping("/{id}/edit")
    public String updateTask(@PathVariable UUID id, @ModelAttribute Task task) {
        Task updatedTask = taskService.updateTask(id, task);
        if (updatedTask != null) {
            return "redirect:/tasks";
        } else {
            return "redirect:/tasks/" + id + "/edit";
        }
    }

    @GetMapping("/{id}/delete")
    public String deleteTask(@PathVariable UUID id) {
        taskService.deleteTask(id);
        return "redirect:/tasks";
    }
}