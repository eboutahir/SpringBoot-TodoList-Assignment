package com.TP1.ToDoList.services;

import com.TP1.ToDoList.entity.Todo;
import com.TP1.ToDoList.repository.ToDoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class TodoServices {

    @Autowired
    ToDoRepository todoRepository;

    public ArrayList<Todo> getAllTodos() {
        ArrayList<Todo> todoList = new ArrayList<>();
        todoRepository.findAll().forEach(todo -> todoList.add(todo));
        return todoList;
    }

    public Todo getTodoById(Long id) {
        return todoRepository.findById(id).get();
    }






    public boolean deleteTodo(Long id) {
        todoRepository.deleteById(id);
        if(todoRepository.findById(id).isEmpty()) {
            return true;
        }
        return false;
    }

    public boolean saveOrUpdateToDo(Todo todo) {
        Todo updatedObj = todoRepository.save(todo);

        if (getTodoById(updatedObj.getId()) != null) {
            return true;
        }

        return false;
    }




}
