package com.Rhazali.spring.ToDoList.Repositories;

import java.util.List;

import javax.transaction.Transactional;

import com.Rhazali.spring.ToDoList.Entities.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
@Transactional
public interface TaskRepository extends JpaRepository<Task, Integer> {
  List<Task> findByTitleContainingIgnoreCase(String keyword);

  @Query("UPDATE Task t SET t.published = :published WHERE t.id = :id")
  @Modifying
  public void updatePublishedStatus(Integer id, boolean published);
}
