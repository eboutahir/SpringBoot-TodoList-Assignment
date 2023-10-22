package com.TP1.ToDoList.repository;

import com.TP1.ToDoList.entity.Todo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ToDoRepository extends JpaRepository<Todo,Long> {

}
