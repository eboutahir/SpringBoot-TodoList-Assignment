package com.Rhazali.spring.ToDoList.Controllers;

import com.Rhazali.spring.ToDoList.Entities.Task;
import com.Rhazali.spring.ToDoList.Services.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
public class TasksController {

  @Autowired
  private TaskService taskService;

  @GetMapping("/tasks")
  public String getAll(Model model, @RequestParam(name = "keyword", required = false) String keyword) {
    List<Task> tasks = taskService.getAllTasks(keyword);
    model.addAttribute("tasks", tasks);
    return "tasks"; // Change "tutorials" to "tasks"
  }

  @GetMapping("/tasks/new")
  public String addTask(Model model) {
    Task task = new Task();
    task.setPublished(true);
    model.addAttribute("task", task);
    model.addAttribute("pageTitle", "\uD83C\uDD72\uD83C\uDD81\uD83C\uDD74\uD83C\uDD70\uD83C\uDD83\uD83C\uDD74 \uD83C\uDD7D\uD83C\uDD74\uD83C\uDD86 \uD83C\uDD83\uD83C\uDD70\uD83C\uDD82\uD83C\uDD7A");
    return "task_form"; // Change "tutorial_form" to "task_form"
  }

  @PostMapping("/tasks/save")
  public String saveTask(Task task, RedirectAttributes redirectAttributes) {
    taskService.saveTask(task);
    redirectAttributes.addFlashAttribute("message", "The Task has been saved successfully!");
    return "redirect:/tasks"; // Change "tutorials" to "tasks"
  }

  @GetMapping("/tasks/{id}")
  public String editTask(@PathVariable("id") Integer id, Model model, RedirectAttributes redirectAttributes) {
    Task task = taskService.getTaskById(id);
    if (task != null) {
      model.addAttribute("task", task);
      model.addAttribute("pageTitle", "Edit Task (ID: " + id + ")");
      return "task_form"; // Change "tutorial_form" to "task_form"
    } else {
      redirectAttributes.addFlashAttribute("message", "Task not found.");
      return "redirect:/tasks"; // Change "tutorials" to "tasks"
    }
  }

  @GetMapping("/tasks/delete/{id}")
  public String deleteTask(@PathVariable("id") Integer id, RedirectAttributes redirectAttributes) {
    taskService.deleteTask(id);
    redirectAttributes.addFlashAttribute("message", "The Task with id=" + id + " has been deleted successfully!");
    return "redirect:/tasks"; // Change "tutorials" to "tasks"
  }

  @GetMapping("/tasks/{id}/published/{status}")
  public String updateTaskPublishedStatus(
          @PathVariable("id") Integer id,
          @PathVariable("status") boolean published,
          RedirectAttributes redirectAttributes
  ) {
    taskService.updateTaskPublishedStatus(id, published);
    String status = published ? "published" : "disabled";
    String message = "The Task id=" + id + " has been " + status;
    redirectAttributes.addFlashAttribute("message", message);
    return "redirect:/tasks"; // Change "tutorials" to "tasks"
  }
}
