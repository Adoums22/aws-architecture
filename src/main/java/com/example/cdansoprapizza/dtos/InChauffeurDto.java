package com.example.cdansoprapizza.dtos;

import java.time.LocalDate;

public class InChauffeurDto {

    private String nom;
    private String prenom;
    private LocalDate dateDeNaissance;
    private LocalDate dateDInscription;
    private String type;

    // Getters and Setters
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
