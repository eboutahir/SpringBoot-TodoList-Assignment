package com.todolistBackend.todolistBackend.model;

import jakarta.persistence.*;

import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "task")
public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_task")
    private Long id;

    @Column(name = "title")
    @NotEmpty(message = "tast title is empty")
    private String title;

    @Column(name = "description")
    private String description;

    @Column(name = "is_completed")
    private boolean completed;
}