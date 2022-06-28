package com.iset_sfax.mini_projet.services;

import com.iset_sfax.mini_projet.dto.GroupeDto;
import com.iset_sfax.mini_projet.entities.Groupe;
import com.iset_sfax.mini_projet.repositories.DepartementRepository;
import com.iset_sfax.mini_projet.repositories.GroupeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
public class GroupeService {

    private final GroupeRepository groupeRepository;
    private final DepartementRepository departementRepository;

    @Autowired
    public GroupeService(GroupeRepository groupeRepository, DepartementRepository departementRepository) {
                this.groupeRepository = groupeRepository;
        this.departementRepository = departementRepository;
    }

    public List<GroupeDto> getGroupes(){
        List<Groupe> groupeList = groupeRepository.findAll();
        List<GroupeDto> groupeDtoList = new ArrayList<>();

        for (Groupe groupe:groupeList
             ) {
            System.out.println(groupe.getNomGroupe());
            GroupeDto groupeDto = new GroupeDto();
            groupeDto.setIdGroupe(groupe.getIdGroupe());
            groupeDto.setNomGroupe(groupe.getNomGroupe());
            groupeDto.setDateCreation(String.valueOf(groupe.getDateCreation()));
            groupeDto.setAu(groupe.getAu());
            groupeDto.setIdDepartement(groupe.getDepartement().getIdDep());
            groupeDtoList.add(groupeDto);

        }
        return groupeDtoList ;
    }

    public void addNewGroupe(GroupeDto groupeDto) {
        Groupe groupe = new Groupe();
        groupe.setIdGroupe(groupeDto.getIdGroupe());
        groupe.setNomGroupe(groupeDto.getNomGroupe());
        groupe.setDateCreation(LocalDate.parse(String.valueOf(groupeDto.getDateCreation())));
        groupe.setAu(groupeDto.getAu());
        groupe.setDepartement(departementRepository.findDepartementByIdDep(groupeDto.getIdDepartement()));
        groupeRepository.save(groupe);
    }
}
