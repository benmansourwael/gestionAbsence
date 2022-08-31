package com.iset_sfax.mini_projet.controllers;

import com.iset_sfax.mini_projet.dto.EtudiantDto;
import com.iset_sfax.mini_projet.dto.post.EtudiantDtoPost;
import com.iset_sfax.mini_projet.entities.Etudiant;
import com.iset_sfax.mini_projet.services.EtudiantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.security.NoSuchAlgorithmException;
import java.util.List;
import java.util.Optional;

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
    public List<EtudiantDto> getEtudiants() {
        return etudiantService.getEtudiants();
    }

//    @GetMapping("/{GroupeName}")
//    public List<EtudiantDto> getEtudiantsByGroupName(@PathVariable("GroupeName") String GroupeName) {
//        return etudiantService.getEtudiantsByGroupName(GroupeName);
//    }

    @GetMapping("/{GroupeId}")
    public List<EtudiantDto> getEtudiantsByGroupeId(@PathVariable("GroupeId") int GroupeId) {
        return etudiantService.getEtudiantsByGroupeId(GroupeId);
    }

    @PostMapping
    public void addnewEtudiant(@RequestBody EtudiantDtoPost etudiantDtoPost) throws NoSuchAlgorithmException {
        etudiantService.addnewEtudiant(etudiantDtoPost);
    }

    @DeleteMapping(path = "{etudiantId}")
    public void deleteEtudiant(@PathVariable("etudiantId") int numEtd) {
        etudiantService.deleteEtudiant(numEtd);
    }
}
