package com.example.cdansoprapizza.services;

import com.example.cdansoprapizza.dtos.CourseDto;
import com.example.cdansoprapizza.dtos.ClientStatsDto;
import com.example.cdansoprapizza.entities.CourseEntity;
import com.example.cdansoprapizza.entities.ClientEntity;
import com.example.cdansoprapizza.repositories.CourseRepository;
import com.example.cdansoprapizza.repositories.ClientRepository;
import com.example.cdansoprapizza.repositories.ChauffeurRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseService implements ICourseService {

    @Autowired
    private CourseRepository courseRepository;

    @Autowired
    private ClientRepository clientRepository;

    @Autowired
    private ChauffeurRepository chauffeurRepository;

    @Override
    public Integer addCourse(CourseDto dto) {
        CourseEntity course = new CourseEntity();
        course.setClient(clientRepository.findById(dto.getClient()).orElseThrow(() -> new RuntimeException("Client not found")));
        course.setChauffeur(chauffeurRepository.findById(dto.getChauffeur()).orElseThrow(() -> new RuntimeException("Chauffeur not found")));
        course.setDateCourse(dto.getDateCourse());
        course.setTempsTrajet(dto.getTempsTrajet());
        course.setDistanceParcourue(dto.getDistanceParcourue());

        courseRepository.save(course);
        return course.getId();
    }

    @Override
    public ClientStatsDto getClientStats(Integer clientId) {
        ClientEntity client = clientRepository.findById(clientId).orElseThrow(() -> new RuntimeException("Client not found"));

        List<CourseEntity> courses = courseRepository.findByClient_Id(clientId);
        int nbCourse = courses.size();
        double distanceTotal = courses.stream().mapToDouble(CourseEntity::getDistanceParcourue).sum();

        ClientStatsDto stats = new ClientStatsDto();
        stats.setClientName(client.getNom() + " " + client.getPrenom());
        stats.setNbCourse(nbCourse);
        stats.setDistanceTotal(distanceTotal);

        return stats;
    }
}
