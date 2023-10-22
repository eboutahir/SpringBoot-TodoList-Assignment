package com.example.ToDoApp;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.ToDoApp.ToDo;

@Repository
public interface IToDoRepo extends JpaRepository<ToDo, Long>{

}
