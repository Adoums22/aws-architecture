package com.example.cdansoprapizza.services;

import com.example.cdansoprapizza.dtos.ClientStatsDto;
import com.example.cdansoprapizza.dtos.CourseDto;
import com.example.cdansoprapizza.entities.CourseEntity;

import java.util.List;

public interface ICourseService {

    /**
     * Insère une course en base
     * @return l'identifiant de la course créée
     */
    Integer addCourse(CourseDto dto);

    /**
     * Affiche le nombre de courses d'un client et la somme de la distance parcourue
     *
     * @param clientId l'identifiant du client
     * @return les statistiques du client
     */
    ClientStatsDto getClientStats(Integer clientId);
}
