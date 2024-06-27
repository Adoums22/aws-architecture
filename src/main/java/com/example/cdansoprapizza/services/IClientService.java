package com.example.cdansoprapizza.services;

import com.example.cdansoprapizza.dtos.InChauffeurDto;
import com.example.cdansoprapizza.dtos.InClientDto;
import com.example.cdansoprapizza.dtos.OutChauffeurDto;
import com.example.cdansoprapizza.dtos.OutClientDto;
import com.example.cdansoprapizza.entities.ChauffeurEntity;
import com.example.cdansoprapizza.entities.ClientEntity;

import java.util.List;

public interface IClientService {
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
    OutClientDto toDto(ClientEntity entity);

    /**
     * Recupere une entité par l'ID
     * @param Id
     * @return
     */
    ClientEntity get(int Id);

    Integer ajouter (OutClientDto dto);

    List<OutClientDto> getAll();

    Boolean delete (Integer id);

    ClientEntity toEntty(InClientDto dto);
}
