package com.iset_sfax.mini_projet.controllers;

import com.iset_sfax.mini_projet.entities.Assiduite;
import com.iset_sfax.mini_projet.dto.AssiduiteDto;
import com.iset_sfax.mini_projet.services.AssiduiteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping(path = "/api/assiduite")
public class AssiduiteController {

    private final AssiduiteService assiduiteService;

    @Autowired
    public AssiduiteController(AssiduiteService assiduiteService) {
        this.assiduiteService = assiduiteService;
    }

    @GetMapping
    public List<Assiduite> getAssiduites(){
        return assiduiteService.getAssiduites();
    }

    @PostMapping
    public void addNewAssiduite(@RequestBody AssiduiteDto assiduiteDto){
        assiduiteService.addNewAssiduite(assiduiteDto);
    }

    @DeleteMapping( path="{assiduiteId}")
    public void deleteAssiduite(@PathVariable("assiduiteId") int assiduiteId){
        assiduiteService.deleteAssiduite(assiduiteId);
    }
}
