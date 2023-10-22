package com.TODO.TodoList.Repository;

import com.TODO.TodoList.Models.Todo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RepositoryTodo   extends JpaRepository<Todo, Long>  {
}
