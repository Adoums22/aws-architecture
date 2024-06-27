package com.example.cdansoprapizza.entities;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "chauffer")
public class ChauffeurEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "nom")
    private String nom;

    @Column(name = "prenom")
    private String prenom;

    @Column(name = "date_de_naissance")
    private LocalDate dateDeNaissance;

    @Column(name = "date_d_inscription")
    private LocalDate dateDInscription;

    @Column(name = "type_chauffeur")
    private String type;

    // Getters and Setters
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public LocalDate getDateDeNaissance() {
        return dateDeNaissance;
    }

    public void setDateDeNaissance(LocalDate dateDeNaissance) {
        this.dateDeNaissance = dateDeNaissance;
    }

    public LocalDate getDateDInscription() {
        return dateDInscription;
    }

    public void setDateDInscription(LocalDate dateDInscription) {
        this.dateDInscription = dateDInscription;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
