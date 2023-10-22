package com.SpringExemple.demo.Controller;

import com.SpringExemple.demo.Services.TodoService;
import com.SpringExemple.demo.Entities.Todo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class TodoController {
    @Autowired
    private TodoService todoService;

    @GetMapping("/")
    public String listTodos(Model model) {
        List<Todo> todos = todoService.getAllTodos();
        model.addAttribute("todos", todos);
        return "todolist";
    }
    @PostMapping("/add")
    public String addTodo(@ModelAttribute Todo todo) {
        todoService.addTodo(todo);
        return "redirect:/";
    }
    @PostMapping("/delete/{id}")
    public String deleteTodo(@PathVariable Long id) {
        todoService.deleteTodoById(id);
        return "redirect:/";
    }
    @PostMapping("/update/{id}")
    public String updateTodo(@ModelAttribute Todo todo) {
        todoService.updateTodo(todo);
        return "redirect:/";
    }
}
