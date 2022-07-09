package com.iset_sfax.mini_projet.controllers;

import com.iset_sfax.mini_projet.dto.EnseignantDto;
import com.iset_sfax.mini_projet.dto.post.EnseignantDtoPost;
import com.iset_sfax.mini_projet.entities.Enseignant;
import com.iset_sfax.mini_projet.services.EnseignantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping(path = "/api/enseignant")
public class EnseignantController {
    private final EnseignantService enseignantService;

    @Autowired
    public EnseignantController(EnseignantService enseignantService) {
        this.enseignantService = enseignantService;
    }

    @GetMapping
    public List<EnseignantDto> getEnseignants(){

        return enseignantService.getEnseignants();
    }

    @PostMapping
    public void addnewEnseignant(@RequestBody EnseignantDtoPost enseignantDtoPost){
        enseignantService.addnewEnseignant(enseignantDtoPost);
    }

    @DeleteMapping(path = "{enseignantId}")
    public void deleteEnseignant(@PathVariable("enseignantId") int numEns){
        enseignantService.deleteEnseignant(numEns);
    }
}
