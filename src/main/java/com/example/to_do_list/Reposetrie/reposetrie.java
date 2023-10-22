package com.example.to_do_list.Reposetrie;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import com.example.to_do_list.entity.Task;


public interface reposetrie extends JpaRepository<Task, Long> {
    List<Task> findByName(String name);  
}
