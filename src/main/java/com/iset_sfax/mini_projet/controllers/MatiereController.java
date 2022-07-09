package com.iset_sfax.mini_projet.controllers;

import com.iset_sfax.mini_projet.dto.MatiereDto;
import com.iset_sfax.mini_projet.entities.Matiere;
import com.iset_sfax.mini_projet.services.MatiereService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping(path = "/api/matiere")
public class MatiereController {
    private final MatiereService matiereService;

    @Autowired
    public MatiereController(MatiereService matiereService) {
        this.matiereService = matiereService;
    }


    @GetMapping
    public List<Matiere> getMatieres(){

        return matiereService.getMatieres();
    }

    @PostMapping
    public void addNewMatiere(@RequestBody MatiereDto matiereDto){
        matiereService.addNewMatiere(matiereDto);
    }

    @DeleteMapping(path = "{matiereId}")
    public void deleteMatiere(@PathVariable("matiereId") int idMat){
        matiereService.deleteMatiere(idMat);
    }

}


