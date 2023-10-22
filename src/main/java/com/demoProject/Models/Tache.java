package com.demoProject.Models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="Tache")
@Data
@AllArgsConstructor @NoArgsConstructor
public class Tache {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long idTache;
    private String toDo;
    private boolean complited;
}



