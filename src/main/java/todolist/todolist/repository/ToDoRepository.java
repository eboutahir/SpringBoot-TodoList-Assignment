package todolist.todolist.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import todolist.todolist.model.ToDo;

@Repository
public interface ToDoRepository extends JpaRepository<ToDo, Long>{
}
