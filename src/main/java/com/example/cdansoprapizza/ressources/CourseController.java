package com.example.cdansoprapizza.ressources;

import com.example.cdansoprapizza.dtos.CourseDto;
import com.example.cdansoprapizza.dtos.ClientStatsDto;
import com.example.cdansoprapizza.services.ICourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/course")
public class CourseController {

    @Autowired
    private ICourseService courseService;

    @PostMapping("/add")
    public ResponseEntity<?> addCourse(@RequestBody CourseDto dto) {
        try {
            Integer courseId = courseService.addCourse(dto);
            return new ResponseEntity<>(courseId, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>("Erreur interne du serveur", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/clientStats/{clientId}")
    public ResponseEntity<?> getClientStats(@PathVariable Integer clientId) {
        try {
            ClientStatsDto clientStats = courseService.getClientStats(clientId);
            return new ResponseEntity<>(clientStats, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>("Erreur interne du serveur", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}

