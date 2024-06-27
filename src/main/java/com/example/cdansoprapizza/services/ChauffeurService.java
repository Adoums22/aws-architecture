package com.example.cdansoprapizza.services;

import com.example.cdansoprapizza.dtos.InChauffeurDto;
import com.example.cdansoprapizza.dtos.OutChauffeurDto;
import com.example.cdansoprapizza.entities.ChauffeurEntity;
import com.example.cdansoprapizza.repositories.ChauffeurRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.Period;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ChauffeurService implements IChauffeurService {

    @Autowired
    private ChauffeurRepository chauffeurRepository;

    @Override
    public Boolean exist(int ID) {
        return chauffeurRepository.existsById(ID);
    }

    @Override
    public OutChauffeurDto toDto(ChauffeurEntity entity) {
        OutChauffeurDto dto = new OutChauffeurDto();
        dto.setDisplayName(entity.getNom() + " " + entity.getPrenom());
        int age = Period.between(entity.getDateDeNaissance(), LocalDate.now()).getYears();
        dto.setAge(age);
        dto.setType(entity.getType());
        dto.setYearsOfExperience(Period.between(entity.getDateDInscription(), LocalDate.now()).getYears());
        return dto;
    }

    @Override
    public ChauffeurEntity get(int Id) {
        Optional<ChauffeurEntity> optionalChauffeur = chauffeurRepository.findById(Id);
        if (optionalChauffeur.isPresent()) {
            return optionalChauffeur.get();
        } else {
            throw new RuntimeException("Chauffeur not found for ID: " + Id);
        }
    }

    @Override
    public Integer ajouter(InChauffeurDto dto) {
        ChauffeurEntity entity = toEntty(dto);
        chauffeurRepository.saveAndFlush(entity);

        return entity.getId();
    }

    @Override
    public ChauffeurEntity toEntty(InChauffeurDto dto) {
        ChauffeurEntity entity = new ChauffeurEntity();
        entity.setNom(dto.getNom());
        entity.setPrenom(dto.getPrenom());
        entity.setDateDeNaissance(dto.getDateDeNaissance());
        entity.setDateDInscription(dto.getDateDInscription());
        entity.setType(dto.getType());
        return entity;
    }

    @Override
    public Map<String, Long> getCountByType() {
        List<ChauffeurEntity> chauffeurs = chauffeurRepository.findAll();
        return chauffeurs.stream()
                .collect(Collectors.groupingBy(ChauffeurEntity::getType, Collectors.counting()));
    }

    @Override
    public List<OutChauffeurDto> getAll() {
        return chauffeurRepository.findAll().stream().map(this::toDto).toList();
    }

    @Override
    public Boolean delete(Integer id) {
        try {

            chauffeurRepository.deleteById(id);
            return true;

        }catch (Exception e){

            return false;
        }
    }
}
