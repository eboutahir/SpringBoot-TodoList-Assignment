package com.ToTheListe2.To_the_liste.repo;
import com.ToTheListe2.To_the_liste.model.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Taskrepo extends JpaRepository<Task, Long>
{

}