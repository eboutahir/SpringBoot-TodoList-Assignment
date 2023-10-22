package com.example.TodoList.controller;

import com.example.TodoList.model.Task;
import org.springframework.ui.Model;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import com.example.TodoList.service.TaskService;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;


@Controller
public class TaskController {

    @Autowired
    private TaskService taskService;

    @GetMapping({"/", "viewTask"})
    public String viewAllTask(@NotNull Model model, @ModelAttribute("message") String message) {
        model.addAttribute("list", taskService.getAllTask());
        model.addAttribute("message", message);

        return "viewTask";
    }

    @PostMapping("/addTask")
    public String addTask(Task task) {

        taskService.createTask(task);

        return "redirect:/viewTask";
    }

    @RequestMapping("/deleteTask/{id}")
    public String deleteTask(@PathVariable Long id, RedirectAttributes redirectAttributes) {

        if (taskService.deleteTaskItem(id)) {
            redirectAttributes.addFlashAttribute("successMessage", "La tâche a été supprimée avec succès.");
        } else {
            redirectAttributes.addFlashAttribute("errorMessage", "La suppression de la tâche a échoué.");
        }

        return "redirect:/viewTask";
    }


    @RequestMapping("/updateTaskStatus/{id}")
    public String updateTaskStatus(@PathVariable Long id, RedirectAttributes redirectAttributes){

        if(taskService.updateStatus(id)){
            redirectAttributes.addFlashAttribute("message","Update Success");
            return "redirect:/viewTask";
        }
        redirectAttributes.addFlashAttribute("message","Update Failure");
        return "redirect:/viewTask";
    }




}
