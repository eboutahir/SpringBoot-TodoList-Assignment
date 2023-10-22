package com.example.to_do_list.Controller;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.config.Task;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.ui.Model;


import com.example.to_do_list.services.service;

@Controller
public class Controllertask {
@Autowired
    private final service taskService;
    public Controllertask(service taskService) {
        this.taskService = taskService;
    }
  //list of task
    @GetMapping("/tasks")
    public String viewTasks(Model model) {
        taskService.viewtask(model);
        return "to_do_list";
    }

    //add task
     @PostMapping("/add/tasks")
     public String Addtask(@RequestParam String name) {
        taskService.Addtask(name);
        return "redirect:/tasks";
    }

  //delete task
    
    @GetMapping("/tasks/{Id}/delete")
    public String deleteTask(@PathVariable long Id) {
     taskService.deleteTask(Id);
     return "redirect:/tasks";
    }

    // update  task
 
    @PatchMapping("/tasks/{taskId}/edit")
    public String editTask(
        @PathVariable Long taskId,
        @RequestBody Map<String, Object> taskData
    ) {
        String name = (String) taskData.get("name");
        String description = (String) taskData.get("description");
        boolean completed = (Boolean) taskData.get("completed");
        taskService.editTask(taskId, name, description, completed);
        return "redirect:/tasks";
    }
   // formulaire
   @GetMapping("/tasks/{taskId}/edit")
    public String editTaskPage(@PathVariable Long taskId, Model model) {
    com.example.to_do_list.entity.Task task = taskService.getTaskById(taskId);
    model.addAttribute("task", task);
    return "update"; 
}











}


