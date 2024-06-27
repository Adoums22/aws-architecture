package com.example.cdansoprapizza.repositories;

import com.example.cdansoprapizza.entities.CourseEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CourseRepository extends JpaRepository<CourseEntity, Integer> {
    List<CourseEntity> findByClient_Id(Integer clientId);
}
