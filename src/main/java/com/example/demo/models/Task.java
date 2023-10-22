package com.example.demo.models;
import jakarta.persistence.*;

@Entity
public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String task;
    private boolean completed;
    public void setId(Long Id)
    {
        this.id=Id;
    }
    public Task(){

    }
    public Task(String task, boolean completed) {
        this.task = task;
        this.completed = completed;
    }
    public Long getId() {
        return id;
    }
    public String getTask() {
        return task;
    }
    public void setTask(String task) {
        this.task = task;
    }
    public boolean isCompleted() {
        return completed;
    }
    public void setCompleted(boolean completed) {
        this.completed = completed;
    }

}
