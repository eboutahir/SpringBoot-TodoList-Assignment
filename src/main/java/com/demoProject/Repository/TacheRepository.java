package com.demoProject.Repository;

import com.demoProject.Models.Tache;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface TacheRepository extends JpaRepository<Tache, Long> {
    Tache getById(Long  idTache);
}











