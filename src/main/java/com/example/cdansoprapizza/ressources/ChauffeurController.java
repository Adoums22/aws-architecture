package com.example.cdansoprapizza.ressources;

import com.example.cdansoprapizza.dtos.InChauffeurDto;
import com.example.cdansoprapizza.dtos.OutChauffeurDto;
import com.example.cdansoprapizza.entities.ChauffeurEntity;
import com.example.cdansoprapizza.enumation.typeChauffeur;
import com.example.cdansoprapizza.services.ChauffeurService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/chauffeur")
public class ChauffeurController {

    @Autowired
    private ChauffeurService chauffeurService;

    @GetMapping("/test")
    public String test(){
        return "hello";
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<?> get(@PathVariable String id){
        try {
            Integer ID = Integer.parseInt(id);

            // Verification si l'ID existe en base
            if (!chauffeurService.exist(ID)) {
                return new ResponseEntity<>("Le chauffeur n'existe pas", HttpStatus.BAD_REQUEST);
            }

            // Sinon
            ChauffeurEntity entity = chauffeurService.get(ID);
            OutChauffeurDto dto = chauffeurService.toDto(entity);

            return new ResponseEntity<>(dto, HttpStatus.OK);
        } catch (NumberFormatException e) {
            return new ResponseEntity<>("ID invalide", HttpStatus.BAD_REQUEST);
        } catch (Exception e) {
            return new ResponseEntity<>("Erreur interne du serveur", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("add")
    public ResponseEntity add (@RequestBody InChauffeurDto dto){

        // je dois controller mon dto

        try {
            typeChauffeur.valueOf(dto.getType());
        }catch (Exception e) {
            return new ResponseEntity("type de chauffeur incorrect", HttpStatusCode.valueOf(400));
        }

        int id = chauffeurService.ajouter(dto);
        return new ResponseEntity(id, HttpStatusCode.valueOf(200));
    }

    @PostMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable Integer id) {
        try {
            Boolean isDeleted = chauffeurService.delete(id);
            if (isDeleted) {
                return new ResponseEntity<>("Chauffeur supprimé avec succès", HttpStatus.valueOf(200));
            } else {
                return new ResponseEntity<>("Échec de la suppression du chauffeur", HttpStatus.INTERNAL_SERVER_ERROR);
            }
        } catch (Exception e) {
            return new ResponseEntity<>("Erreur interne du serveur", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/all")
    public ResponseEntity<List<OutChauffeurDto>> getAll() {
        try {
            List<OutChauffeurDto> allChauffeurs = chauffeurService.getAll();
            return new ResponseEntity<>(allChauffeurs, HttpStatus.valueOf(200));
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/stats")
    public ResponseEntity<Map<String, Long>> getStats() {
        try {
            Map<String, Long> stats = chauffeurService.getCountByType();
            return new ResponseEntity<>(stats, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


}
