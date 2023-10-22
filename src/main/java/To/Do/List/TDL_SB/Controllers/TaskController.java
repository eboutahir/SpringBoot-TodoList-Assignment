package To.Do.List.TDL_SB.Controllers;

import To.Do.List.TDL_SB.Models.TaskModel;
import To.Do.List.TDL_SB.Services.TaskService;
import To.Do.List.TDL_SB.Services.TaskServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import jakarta.validation.Valid;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequestMapping("tasks")
public class TaskController {
    @Autowired
    private TaskService taskService;
    @GetMapping("/listPage")
    public String  List(Model model){
        List<TaskModel> tasks = taskService.getAll();
        model.addAttribute("tasks", tasks);
        return "listPage";
    }

    @GetMapping("/updatetask/{id}")
    public String updatetask(@PathVariable("id") Integer id,Model model){
        TaskModel task = taskService.getById(id);
        model.addAttribute("task", task);
        return "modifier";
    }

    @PostMapping ("/edit/{id}")
    public String updatetask2(@PathVariable("id") Integer id,@ModelAttribute("task") @Valid TaskModel taskModel){
        TaskModel task = taskService.getById(id);
        taskService.updateTask(id,taskModel);
        return "redirect:/tasks/listPage";
    }
    @GetMapping("/delete/{id}")
    public String deleteTask(@PathVariable("id") Integer id, RedirectAttributes redirectAttributes) {
        if (taskService.getById(id) != null) {
            taskService.deleteTask(id);
            redirectAttributes.addFlashAttribute("notification", "Task with id=" + id + " deleted successfully");
            return "redirect:/tasks/listPage";
        } else {
            redirectAttributes.addFlashAttribute("notification", "Task with id=" + id + " Not exist");
            return "redirect:/tasks/listPage";
        }
    }

    @GetMapping("/addtask")
    public String showAddTask(Model model) {
        model.addAttribute("task", new TaskModel());
        return "addtask";
    }
    @PostMapping("/add")
    public String addTask(@ModelAttribute("task") @Valid TaskModel taskModel, BindingResult bindingResult, RedirectAttributes redirectAttributes) {
        if (bindingResult.hasErrors()) {
            redirectAttributes.addFlashAttribute("notification", "Task not added, please check your input information");
            return "redirect:/tasks/add";
        }
            taskService.addTask(taskModel);
            redirectAttributes.addFlashAttribute("notification", "Task added successfully");
            return "redirect:/tasks/listPage";
    }
//
//
//    @Autowired
//    private TaskServiceImp service;
//
//
//    @GetMapping("/Home")
//    public String Home() {
//        return "index"; // This maps to "Home.html" in the "templates" directory.
//    }
//
//
//    @GetMapping ({"/", "list"})
//    public String viewAllToDoItems(Model model, @ModelAttribute ("message") String message) {
//        model.addAttribute("list", service.getAllToDoItems());
//        model.addAttribute("message", message);
//
//        return "list";
//    }
//
//    @GetMapping("/updateToDoStatus/{id}")
//    public String updateToDoStatus(@PathVariable Long id, RedirectAttributes redirectAttributes) {
//        if (service.updateStatus(id)) {
//            redirectAttributes.addFlashAttribute("message", "Update Success");
//            return "redirect:/list";
//        }
//
//        redirectAttributes.addFlashAttribute("message", "Update Failure");
//        return "redirect:/list";
//    }
//
//    @GetMapping("/form")
//    public String addToDoItem(Model model) {
//        model.addAttribute("task", new TaskModel());
//
//        return "form";
//    }
//
//    @PostMapping ("/saveToDoItem")
//    public String saveToDoItem(TaskModel task, RedirectAttributes redirectAttributes) {
//        if(service.saveOrUpdateToDoItem(task)) {
//            redirectAttributes.addFlashAttribute("message", "Save Success");
//            return "redirect:/list";
//        }
//
//        redirectAttributes.addFlashAttribute("message", "Save Failure");
//        return "redirect:/form";
//    }
//
//    @GetMapping("/editToDoItem/{id}")
//    public String editToDoItem(@PathVariable Integer id, Model model) {
//        model.addAttribute("todo", service.getToDoItemById(Long.valueOf(id)));
//
//        return "EditToDoItem";
//    }
//
//    @PostMapping("/editSaveToDoItem")
//    public String editSaveToDoItem(TaskModel todo, RedirectAttributes redirectAttributes) {
//        if(service.saveOrUpdateToDoItem(todo)) {
//            redirectAttributes.addFlashAttribute("message", "Edit Success");
//            return "redirect:/list";
//        }
//
//        redirectAttributes.addFlashAttribute("message", "Edit Failure");
//        return "redirect:/editToDoItem/" + todo.getId();
//    }
//
//    @GetMapping("/deleteToDoItem/{id}")
//    public String deleteToDoItem(@PathVariable Integer id, RedirectAttributes redirectAttributes) {
//        if (service.deleteToDoItem(id)) {
//            redirectAttributes.addFlashAttribute("message", "Delete Success");
//            return "redirect:/list";
//        }
//
//        redirectAttributes.addFlashAttribute("message", "Delete Failure");
//        return "redirect:/list";
//    }

}
