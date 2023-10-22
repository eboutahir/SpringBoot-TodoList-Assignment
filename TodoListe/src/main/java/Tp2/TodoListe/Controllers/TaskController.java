package Tp2.TodoListe.Controllers;

import Tp2.TodoListe.Models.Task;
import Tp2.TodoListe.Service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/Tp2/Tasks")
public class TaskController
{
    @Autowired
    private TaskService taskService;

    @GetMapping
    public  List<Task> getAllTasks() {

     return taskService.getAllTasks();


    }
    @GetMapping("/{id}")
    public Task getTaskById(@PathVariable Long id) {
        return taskService.getTaskById(id);
    }
    @PostMapping("/createTask")
    public Task createTask(@RequestBody Task task) {
        return taskService.createTask(task);
    }

    @PutMapping("/{id}")
    public Task updateTask(@PathVariable Long id, @RequestBody Task task) {
        return taskService.updateTask(id, task);
    }

    @DeleteMapping("/{id}")
    public void deleteTask(@PathVariable Long id) {
        taskService.deleteTask(id);
    }

    @GetMapping("/byNom/{Nom}")
    public List<Task> getTasksByNom(@PathVariable String Nom) {
        return taskService.findTaskByNom(Nom);
    }





}
