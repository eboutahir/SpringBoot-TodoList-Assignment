package To.Do.List.TDL_SB.Controllers;

import To.Do.List.TDL_SB.Models.TaskModel;
import To.Do.List.TDL_SB.Services.TaskService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("tasksss")
@AllArgsConstructor
public class TaskControllerRest {
    @Autowired
    private TaskService taskService;
    @PostMapping
    public TaskModel addTask(@RequestBody TaskModel taskModel){
        return taskService.addTask(taskModel);
    }
    @DeleteMapping
    public void deleteTask(@RequestParam("yasmina") Integer id){
        taskService.deleteTask(id);
    }
    @DeleteMapping("/{id}")
    public void deleteTask2(@PathVariable("id") Integer id){
        taskService.deleteTask(id);
    }
    @GetMapping("/list")
    public List<TaskModel> list(){
        return taskService.getAll();
    }
    @PutMapping
    public void updateTask(@RequestBody TaskModel taskModel){
        taskService.update(taskModel);
    }

}
