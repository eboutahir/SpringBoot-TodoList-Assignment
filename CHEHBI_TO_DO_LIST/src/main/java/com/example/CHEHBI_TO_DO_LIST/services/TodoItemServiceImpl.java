package com.example.CHEHBI_TO_DO_LIST.services;

import com.example.CHEHBI_TO_DO_LIST.models.TodoItem;
import com.example.CHEHBI_TO_DO_LIST.repositories.TodoItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class TodoItemServiceImpl implements TodoItemService{
    @Autowired
    private TodoItemRepository todoItemRepository;

    @Override
    public List<TodoItem> getAllTasks() {
       return todoItemRepository.findAll();
    }

    @Override
    public void saveTask(TodoItem todoItem) {
        Date currentDate = new Date();

        // Définissez le format de date souhaité
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM");

        // Obtenez la date au format souhaité en tant que chaîne
        String formattedDate = dateFormat.format(currentDate);

        // Définissez la date de création dans l'objet TodoItem
        todoItem.setCreatedDate(formattedDate);
        todoItemRepository.save(todoItem);
    }

    @Override
    public TodoItem findTodoItemById(Long id) {
        Optional<TodoItem> todoItemOptional = todoItemRepository.findById(id);
        if (todoItemOptional.isPresent()) {
            return todoItemOptional.get();
        } else {
            return null;
        }
    }

    @Override
    public void deleteTask(TodoItem todoItem) {
        todoItemRepository.delete(todoItem);
    }


    @Override
    public void updateCompleteStatus(Long itemId, boolean isComplete) {
        Optional<TodoItem> todoItemOptional = todoItemRepository.findById(itemId);

        if (todoItemOptional.isPresent()) {
            TodoItem todoItem = todoItemOptional.get();
            todoItem.setComplete(isComplete);
            todoItemRepository.save(todoItem);
        }
    }



}
