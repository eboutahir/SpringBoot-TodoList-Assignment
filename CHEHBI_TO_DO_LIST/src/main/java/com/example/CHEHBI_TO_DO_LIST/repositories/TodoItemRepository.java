package com.example.CHEHBI_TO_DO_LIST.repositories;

import com.example.CHEHBI_TO_DO_LIST.models.TodoItem;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface TodoItemRepository extends CrudRepository<TodoItem, Integer> {
    List<TodoItem> findAll();

}
