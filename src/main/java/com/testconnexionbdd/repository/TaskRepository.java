package com.testconnexionbdd.repository;

import com.testconnexionbdd.model.Task;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TaskRepository extends JpaRepository<Task,Long> {

}
