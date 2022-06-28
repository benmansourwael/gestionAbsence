package com.iset_sfax.mini_projet.controllers;

import com.iset_sfax.mini_projet.dto.GroupeDto;
import com.iset_sfax.mini_projet.entities.Groupe;
import com.iset_sfax.mini_projet.services.GroupeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping(path = "/api/groupe")
public class GroupeController {

    private final GroupeService groupeService;
    @Autowired
    public GroupeController(GroupeService groupeService) {
        this.groupeService = groupeService;
    }

    @GetMapping
    public List<GroupeDto> getGroupes(){

        return groupeService.getGroupes();
    }

    @PostMapping
    public void addNewGroupe(@RequestBody GroupeDto groupeDto){
        groupeService.addNewGroupe(groupeDto);
    }

}
