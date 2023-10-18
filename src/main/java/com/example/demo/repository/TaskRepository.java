package com.example.demo.repository;

import com.example.demo.domains.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Repository
public  interface TaskRepository extends JpaRepository<Task, Long> {

    Task getTaskById(Long id);
   Optional<Task>  getOpTaskById(Long id);


    @Query(value = "SELECT t.completed FROM Task t where t.id = :id")
    boolean getStatus(@Param("id") Long id);

    @Modifying
    @Transactional
    @Query("DELETE from Task uapp where uapp.id = :id ")
    Integer deleteTaskById(@Param("id") Long id);

    List<Task> getAll();




}
