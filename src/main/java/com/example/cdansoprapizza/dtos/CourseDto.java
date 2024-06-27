package com.example.cdansoprapizza.dtos;

import java.time.LocalDate;
import java.time.LocalTime;

public class CourseDto {

    private Integer client;
    private Integer chauffeur;
    private LocalDate dateCourse;
    private LocalTime tempsTrajet;
    private Double distanceParcourue;

    // Getters and Setters
    public Integer getClient() {
        return client;
    }

    public void setClient(Integer client) {
        this.client = client;
    }

    public Integer getChauffeur() {
        return chauffeur;
    }

    public void setChauffeur(Integer chauffeur) {
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