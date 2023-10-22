package com.demoProject.Services;

import com.demoProject.Models.Tache;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface TacheService {

    public Tache addTache(Tache task);
    public Tache getTacheById(Long taskId);
    public Tache updateTache(Long id , Tache t);
    public String deleteTache(Long  id);
    public List<Tache> getAllTaches();
}











