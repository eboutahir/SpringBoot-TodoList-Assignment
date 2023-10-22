package com.TP1.ToDoList;


import com.TP1.ToDoList.repository.ToDoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication

public class ToDoListApplication  {




	public static void main(String[] args) {
		SpringApplication.run(ToDoListApplication.class, args);
	}


}