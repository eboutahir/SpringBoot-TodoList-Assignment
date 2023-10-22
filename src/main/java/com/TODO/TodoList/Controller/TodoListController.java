package com.TODO.TodoList.Controller;

import com.TODO.TodoList.Models.Todo;
import com.TODO.TodoList.Service.ServiceTodo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class TodoListController {
    @Autowired
    private ServiceTodo serviceTodo;
    @GetMapping("/")
    public String index(Model model){
        List<Todo> todos = serviceTodo.getAllTodo();
        model.addAttribute("todos", todos);
        return "index";
    }
    @PostMapping("/createTodo")
    public String createTodo(@ModelAttribute Todo todo, Model model) {
         serviceTodo.createTodo(todo);
         model.addAttribute("successMessage", "Tâche ajoutée avec succès.");
         return "redirect:/";
    }
    @GetMapping("/showTodo/{id}")
    public String showEditTodoForm(@PathVariable Long id, Model model) {
         Todo todo = serviceTodo.getTodoById(id);
         if (todo != null) {
            model.addAttribute("todo", todo);
         }
         return "Edit";
    }

    @PostMapping("/editTodo/{id}")
    public String editTodo(@PathVariable Long id, @ModelAttribute Todo updatedTodo) {
         serviceTodo.updateTodo(id, updatedTodo);
         return "redirect:/";
    }
    @PostMapping("/deleteTodo/{id}")
    public String deleteTodo(@PathVariable Long id) {
         serviceTodo.deleteTodo(id);
         return "redirect:/";
    }
}
