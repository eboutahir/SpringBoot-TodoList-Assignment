package com.testconnexionbdd.controller;

import com.testconnexionbdd.model.Task;
import com.testconnexionbdd.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class TaskController {
    @Autowired
    TaskService taskService;

    @GetMapping("/index")
    public String findAllTasks(Model model){
        List<Task> tasks = taskService.getAllTasks();
        model.addAttribute("tasks", tasks);
        return "index";
    }
    @PostMapping("/ajou")
    public String  Ajoutte(@ModelAttribute Task task){
        Task task1= taskService.CreateTask(task);
        return "redirect:/index";
    }
    @DeleteMapping("/supp/{i}")
    public String supprimer(@PathVariable Long i){
        taskService.deleteTask(i);
        return "redirect:/index";
    }
    @PostMapping("/modi/{id}")
    public String modifier(@ModelAttribute Task task) {
         taskService.updateTask(task);
         return "redirect:/index";
    }

}
