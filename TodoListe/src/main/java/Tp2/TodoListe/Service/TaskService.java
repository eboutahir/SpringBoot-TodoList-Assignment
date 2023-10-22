package Tp2.TodoListe.Service;

import Tp2.TodoListe.Models.Task;
import Tp2.TodoListe.Repositorys.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskService
{
    @Autowired
    private TaskRepository taskRepository;
    public List<Task> getAllTasks() {
        return taskRepository.findAll();
    }


    public Task getTaskById(Long id) {
        return taskRepository.findById(id).orElse(null);
    }

    public Task createTask(Task task) {
        return taskRepository.save(task);
    }

    public Task updateTask(Long id, Task task) {
        Task existTask = taskRepository.findById(id).orElse(null);
        if (existTask != null) {
            existTask.setNom(task.getNom());
            existTask.setDescription(task.getDescription());
            existTask.setCategorie(task.getCategorie());
            existTask.setDone(task.getDone());
            Task updateTask= taskRepository.save(existTask);
        }
        return null;
    }

    public void deleteTask(Long id) {
        taskRepository.deleteById(id);
    }

    public List<Task> findTaskByNom(String Nom) {
        return taskRepository.findByNom(Nom);
    }









}
