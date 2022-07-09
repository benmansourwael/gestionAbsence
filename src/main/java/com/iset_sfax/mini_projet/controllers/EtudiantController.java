package com.iset_sfax.mini_projet.controllers;

import com.iset_sfax.mini_projet.dto.EtudiantDto;
import com.iset_sfax.mini_projet.dto.post.EtudiantDtoPost;
import com.iset_sfax.mini_projet.entities.Etudiant;
import com.iset_sfax.mini_projet.services.EtudiantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.List;

@RestController
@CrossOrigin
@RequestMapping(path = "/api/etudiant")
public class EtudiantController {

    private final EtudiantService etudiantService;

    @Autowired
    public EtudiantController(EtudiantService etudiantService) {
        this.etudiantService = etudiantService;

    }


    @GetMapping
    public List<EtudiantDto> getEtudiants(){
       return etudiantService.getEtudiants();
    }

    @GetMapping("/{GroupeName}")
    public List<Etudiant> getEtudiantsByGroupName(@PathVariable("GroupeName") String GroupeName){
        return etudiantService.getEtudiantsByGroupName(GroupeName);
    }

    @PostMapping
        public void addnewEtudiant(@RequestBody EtudiantDtoPost etudiantDtoPost) throws NoSuchAlgorithmException {
        etudiantService.addnewEtudiant(etudiantDtoPost);
    }

    @DeleteMapping(path = "{etudiantId}")
    public void deleteEtudiant(@PathVariable("etudiantId")int numEtd){
        etudiantService.deleteEtudiant(numEtd);
    }
}
