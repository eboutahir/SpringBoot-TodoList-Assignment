package com.TODO.TodoList.Models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;


import java.util.Date;

@Entity
public class Todo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter
    @Setter
    private Long id;
    @Getter
    @Setter
    private String title;
    @Getter
    @Setter
    private String description;
    @Getter
    @Setter
    private boolean completed;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Getter
    @Setter
    private Date date ;
    public Todo(){
        super();
    }
    public  Todo(String title,String des,boolean completed,Date date){
        this.date=date;
        this.completed=completed;
        this.title=title;
        this.description=des;
    }
}
