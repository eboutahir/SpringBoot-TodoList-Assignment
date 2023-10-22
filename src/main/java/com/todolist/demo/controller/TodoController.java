package com.todolist.demo.controller;

import com.todolist.demo.model.TodoEntity;
import com.todolist.demo.servise.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.ui.Model;
import java.util.List;

@Controller


public class TodoController {
    @Autowired
    private TodoService todoService;
    @GetMapping("/")
    public String getAll(Model model)
    {
        List<TodoEntity> listTodo=todoService.recuperer();
        model.addAttribute("todo",listTodo);
        return "home";

    }
    @PostMapping("/ajouter")
    public String ajouter(@ModelAttribute TodoEntity t)
    {
        todoService.createTodo(t);
        return "redirect:/";
    }
    @PostMapping("/modifer/{id}")
    public String modifer(@PathVariable Long id,@ModelAttribute TodoEntity t)
    {
        todoService.modifier(t);
        return "redirect:/";
    }
     @PostMapping("/delete/{id}")
    public String delete(@PathVariable Long id,@ModelAttribute TodoEntity t)
     {
         todoService.supprimer(t);
         return "redirect:/";
     }
}
