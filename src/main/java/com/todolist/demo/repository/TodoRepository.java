package com.todolist.demo.repository;

import com.todolist.demo.model.TodoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface TodoRepository extends JpaRepository<TodoEntity,Long> {

}
