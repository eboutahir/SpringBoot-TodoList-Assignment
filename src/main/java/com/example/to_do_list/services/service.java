package com.example.to_do_list.services;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;

import com.example.to_do_list.Reposetrie.reposetrie;
import com.example.to_do_list.entity.Task;



@Service
public class service {
@Autowired
    private final reposetrie taskRepository;

    public service(reposetrie taskRepository) {
        this.taskRepository = taskRepository;
    }
      
    public void viewtask(Model model) {
        List<Task> tasks = taskRepository.findAll();
        model.addAttribute("tasks", tasks);
    }

    public void Addtask(String name) {
        if (name.trim().length() > 0) {
            Task newTask = new Task();
            newTask.setName(name);
            taskRepository.save(newTask);
        }
    }

    public void deleteTask(long Id) { 
    taskRepository.deleteById(Id);
    }

    public void editTask(Long taskId, String name, String description,boolean completed) {
        Task task = taskRepository.findById(taskId).orElse(null);

        if (task != null) {
            task.setName(name);
            task.setDescription(description);
            task.setCompleted(completed);
            taskRepository.save(task);
        }
    }
  
    public Task getTaskById(Long taskId) {
        return taskRepository.findById(taskId).orElse(null);
    }

    







    

}
