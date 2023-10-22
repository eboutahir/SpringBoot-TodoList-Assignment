package Tp2.TodoListe.Repositorys;

import Tp2.TodoListe.Models.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TaskRepository extends JpaRepository<Task, Long>
{
    List<Task> findByNom(String Nom);
}
