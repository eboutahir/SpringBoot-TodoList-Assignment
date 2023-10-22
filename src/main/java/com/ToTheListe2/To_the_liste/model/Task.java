package com.ToTheListe2.To_the_liste.model;
import jakarta.persistence.*;
import lombok.*;
@Entity
@Table(name = "Tasks")
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@ToString
public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @Column
    private String title;
    @Column
    private String description;

}
