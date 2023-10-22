package com.example.CHEHBI_TO_DO_LIST.controllers;

import com.example.CHEHBI_TO_DO_LIST.models.TodoItem;
import com.example.CHEHBI_TO_DO_LIST.services.TodoItemService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.time.Instant;
import java.time.ZoneId;

@Controller
public class TodoItemController {
    private final Logger logger = LoggerFactory.getLogger(TodoItemController.class);



    @Autowired
    private TodoItemService todoItemService;
    @GetMapping("/home")
    public ModelAndView index() {
        logger.info("request to GET index");
        ModelAndView modelAndView = new ModelAndView("index");
        modelAndView.addObject("todoItems", todoItemService.getAllTasks());
        modelAndView.addObject("today", Instant.now().atZone(ZoneId.systemDefault()).toLocalDate().getDayOfWeek());
        modelAndView.addObject("todoItem",new TodoItem());

        return modelAndView;
    }



    @RequestMapping(value="/addTodo", method=RequestMethod.POST)
    public String contactSubmit(@ModelAttribute TodoItem todoItem, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            logger.info("erreur ");
        }

        todoItemService.saveTask(todoItem);
        return "redirect:/home";
    }


    @GetMapping("/delete/{id}")
    public String deleteTodoItem(@PathVariable("id") int id, Model model) {
        TodoItem todoItem = todoItemService.findTodoItemById(id);

        todoItemService.deleteTask(todoItem);
        return "redirect:/home";
    }

    @PutMapping("/updateComplete")
    public ResponseEntity<String> updateComplete(@RequestBody TodoItem request) {
        int itemId = request.getId();
        boolean isComplete = request.isComplete();

        todoItemService.updateCompleteStatus(itemId, isComplete);

        return new ResponseEntity<>("Task status updated successfully", HttpStatus.OK);
    }


}
