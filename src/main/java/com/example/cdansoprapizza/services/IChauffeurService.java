package com.example.cdansoprapizza.services;

import com.example.cdansoprapizza.dtos.InChauffeurDto;
import com.example.cdansoprapizza.dtos.OutChauffeurDto;
import com.example.cdansoprapizza.entities.ChauffeurEntity;

import java.util.List;
import java.util.Map;

public interface IChauffeurService {

    /**
     * Verifie si l'etudiant existe
     * @param ID ID en base de données
     * @return boolean
     */
    Boolean exist(int ID);

    /**
     * Convertie mon entite en DTO
     * @param entity
     * @return OutEtudiantDto
     */
    OutChauffeurDto toDto(ChauffeurEntity entity);

    /**
     * Recupere une entité par l'ID
     * @param Id
     * @return
     */
    ChauffeurEntity get(int Id);

    Integer ajouter (InChauffeurDto dto);

    List<OutChauffeurDto> getAll();

    Boolean delete (Integer id);

    ChauffeurEntity toEntty(InChauffeurDto dto);

    public Map<String, Long> getCountByType();

}
