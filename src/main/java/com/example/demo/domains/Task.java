package com.example.demo.domains;

import jakarta.persistence.*;
import lombok.*;

@NoArgsConstructor
@EqualsAndHashCode(callSuper = false)
@AllArgsConstructor
@Builder
@Data
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@Entity
@Table(name = "Task")
public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "id_Sequence")
    // this is the primary key which will be auto generated
    private Long id;
    private String taskTodo;
    private boolean completed;
}
