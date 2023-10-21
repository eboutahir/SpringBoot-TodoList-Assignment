package com.example.tp2sp.Model;


    import jakarta.persistence.*;
    import java.util.Date;
    import java.util.UUID;
@Entity
@Table(name="tachetodo")
public class Task {
    @Id
    @GeneratedValue
    private UUID id;
    private String nomTache;
    private String description;
    private boolean complete;
    private Date dateDebut;
    private Date dateFin;

    // Getters et setters

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getNomTache() {
        return nomTache;
    }

    public void setNomTache(String nomTache) {
        this.nomTache = nomTache;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean isComplete() {
        return complete;
    }

    public void setComplete(boolean complete) {
        this.complete = complete;
    }

    public Date getDateDebut() {
        return dateDebut;
    }

    public void setDateDebut(Date dateDebut) {
        this.dateDebut = dateDebut;
    }

    public Date getDateFin() {
        return dateFin;
    }

    public void setDateFin(Date dateFin) {
        this.dateFin = dateFin;
    }
}
