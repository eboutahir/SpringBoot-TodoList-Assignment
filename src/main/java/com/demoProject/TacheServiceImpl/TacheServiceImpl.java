package com.demoProject.TacheServiceImpl;

import com.demoProject.Models.Tache;
import com.demoProject.Repository.TacheRepository;
import com.demoProject.Services.TacheService;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
@Transactional
@AllArgsConstructor
public class TacheServiceImpl implements TacheService {



    @Autowired
    private TacheRepository tacheRepo;

    @Override
    public Tache addTache(Tache task) {
        task.setComplited(false);
        return tacheRepo.save(task);

    }

    @Override
    public Tache getTacheById(Long taskId) {
        return tacheRepo.getById(taskId);
    }


    @Override
    public Tache updateTache(Long id , Tache tacheEntity)  {
        Tache existingTache = tacheRepo.getById(id);

        existingTache.setToDo(tacheEntity.getToDo());
        existingTache.setComplited(tacheEntity.isComplited());

        return tacheRepo.save(existingTache);

    }

    @Override
    public String deleteTache (Long id) {
         tacheRepo.deleteById(id);
         return "Deleted";
    }

    @Override
    public List<Tache> getAllTaches () {
        return tacheRepo.findAll();
    }
}






