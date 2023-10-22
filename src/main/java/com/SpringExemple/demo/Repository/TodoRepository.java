package com.SpringExemple.demo.Repository;
import com.SpringExemple.demo.Entities.Todo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TodoRepository extends JpaRepository<Todo, Long> {

}

