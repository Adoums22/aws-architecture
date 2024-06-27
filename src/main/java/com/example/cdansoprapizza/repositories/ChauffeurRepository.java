package com.example.cdansoprapizza.repositories;

import com.example.cdansoprapizza.entities.ChauffeurEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ChauffeurRepository extends JpaRepository<ChauffeurEntity, Integer> {
}
