package com.example.cdansoprapizza.entities;

import jakarta.persistence.*;
import java.time.LocalDate;
import java.time.LocalTime;

@Entity
@Table(name = "course")
public class CourseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "client_id", referencedColumnName = "id")
    private ClientEntity client;

    @ManyToOne
    @JoinColumn(name = "chauffeur_id", referencedColumnName = "id")
    private ChauffeurEntity chauffeur;

    @Column(name = "date_course")
    private LocalDate dateCourse;

    @Column(name = "temps_trajet")
    private LocalTime tempsTrajet;

    @Column(name = "distance_parcourue")
    private Double distanceParcourue;

    // Getters and Setters
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public ClientEntity getClient() {
        return client;
    }

    public void setClient(ClientEntity client) {
        this.client = client;
    }

    public ChauffeurEntity getChauffeur() {
        return chauffeur;
    }

    public void setChauffeur(ChauffeurEntity chauffeur) {
        this.chauffeur = chauffeur;
    }

    public LocalDate getDateCourse() {
        return dateCourse;
    }

    public void setDateCourse(LocalDate dateCourse) {
        this.dateCourse = dateCourse;
    }

    public LocalTime getTempsTrajet() {
        return tempsTrajet;
    }

    public void setTempsTrajet(LocalTime tempsTrajet) {
        this.tempsTrajet = tempsTrajet;
    }

    public Double getDistanceParcourue() {
        return distanceParcourue;
    }

    public void setDistanceParcourue(Double distanceParcourue) {
        this.distanceParcourue = distanceParcourue;
    }
}