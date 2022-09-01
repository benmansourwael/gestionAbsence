package com.iset_sfax.mini_projet.controllers;

import com.iset_sfax.mini_projet.dto.SeanceCoursDto;
import com.iset_sfax.mini_projet.entities.SeanceCours;
import com.iset_sfax.mini_projet.services.SeanceCoursService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping(path = "/api/seancecours")
public class SeanceCoursController {

    private final SeanceCoursService seanceCoursService;

    @Autowired
    public SeanceCoursController(SeanceCoursService seanceCoursService) {
        this.seanceCoursService = seanceCoursService;
    }


    @GetMapping
    public List<SeanceCoursDto> getSeancesCours() {

        return seanceCoursService.getSeancesCours();
    }


    @GetMapping(path = "/etudiant/{etudiantId}")
    public List<SeanceCoursDto> getSeancesCoursByEtudiantId(@PathVariable("etudiantId") int etudiantId) {

        return seanceCoursService.getSeancesCoursByEtudiantId(etudiantId);
    }

    @GetMapping(path = "{seanceCoursId}")
    public SeanceCoursDto getSeanceCoursById(@PathVariable("seanceCoursId") int idSeance){
        return seanceCoursService.getSeanceCoursById(idSeance);
    }


    @GetMapping(path = "/groupe/")
    public SeanceCoursDto getSeanceCourIndex0(){
        return seanceCoursService.getSeanceCourIndex0();
    }


    @PostMapping
    public void addNewSeanceCours(@RequestBody SeanceCoursDto seanceCoursDto) {
        seanceCoursService.addNewSeanceCours(seanceCoursDto);
    }

    @DeleteMapping(path = "{seanceCoursId}")
    public void deleteSeanceCours(@PathVariable("seanceCoursId") int idSeance){
        seanceCoursService.deleteSeanceCours(idSeance);
    }


}
