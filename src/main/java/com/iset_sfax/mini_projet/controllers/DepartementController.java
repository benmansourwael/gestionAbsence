package com.iset_sfax.mini_projet.controllers;

import com.iset_sfax.mini_projet.entities.Departement;
import com.iset_sfax.mini_projet.dto.DepartementDto;
import com.iset_sfax.mini_projet.services.DepartementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RequestMapping(path = "/api/departement")
@CrossOrigin
@RestController
public class DepartementController {

    private final DepartementService departementService;

    @Autowired
    public DepartementController(DepartementService departementService) {
        this.departementService = departementService;
    }

    @GetMapping
    public List<DepartementDto> getDepartements() {
        return departementService.getDepartements();

    }

    @PostMapping
    public void addNewDepartement(@RequestBody DepartementDto departementDto){
        departementService.addNewDepartement(departementDto);
    }

    @DeleteMapping(path = "{departementId}")
    public void deleteDepartement(@PathVariable("departementId") int idDep){
        departementService.deleteDepartement(idDep);
    }

}
