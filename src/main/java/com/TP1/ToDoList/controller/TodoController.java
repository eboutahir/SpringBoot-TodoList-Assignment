package com.TP1.ToDoList.controller;

import com.TP1.ToDoList.entity.Todo;
import com.TP1.ToDoList.services.TodoServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;





@Controller
public class TodoController {

    @Autowired
    TodoServices todoServices;

    @GetMapping("/ToDoList")
    public String viewAllToDoItems(Model model) {
        model.addAttribute("todos",todoServices.getAllTodos() );
        return "ToDoList";
    }


   
    @GetMapping("/deleteToDo/{id}")
    public String deleteToDo(@PathVariable Long id, RedirectAttributes redirectAttributes) {
        todoServices.deleteTodo(id);
        redirectAttributes.addFlashAttribute("message", "Update Failure");
        return "redirect:/ToDoList";
    }


    @GetMapping("/AddToDo")
    public String addToDoItem(Model model) {
        model.addAttribute("todo", new Todo());

        return "AddToDo";
    }

    @PostMapping("/saveToDo")
    public String saveToDoItem(@ModelAttribute("todo")  Todo todo, RedirectAttributes redirectAttributes) {
        if(todoServices.saveOrUpdateToDo(todo)) {
            redirectAttributes.addFlashAttribute("message", "Save Success");
            return "redirect:/ToDoList";
        }

        redirectAttributes.addFlashAttribute("message", "Save Failure");
        return "redirect:/AddToDo";
    }

    @GetMapping("/EditToDo/{id}")
    public String editToDoItem(@PathVariable Long id, Model model) {
        model.addAttribute("todo",todoServices.getTodoById(id));
        return "EditToDo";
    }

    @PostMapping("/editSaveToDo")
    public String editSaveToDoItem(Todo todo, RedirectAttributes redirectAttributes) {
        if (todoServices.saveOrUpdateToDo(todo)) {
            redirectAttributes.addFlashAttribute("message", "Edit Success");
            return "redirect:/ToDoList";
        }
        redirectAttributes.addFlashAttribute("message", "Edit Failure");
        return "redirect:/EditToDo/" + todo.getId();
    }



}

