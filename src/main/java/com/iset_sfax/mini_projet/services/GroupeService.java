package com.iset_sfax.mini_projet.services;

import com.iset_sfax.mini_projet.dto.GroupeDto;
import com.iset_sfax.mini_projet.entities.Groupe;
import com.iset_sfax.mini_projet.repositories.DepartementRepository;
import com.iset_sfax.mini_projet.repositories.GroupeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.swing.text.html.Option;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

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

    public void deleteGroupe(int idGroupe) {
        Optional<Groupe> groupeById = Optional.ofNullable(groupeRepository.findGroupeByIdGroupe(idGroupe));
        if(!groupeById.isPresent()){
            throw new IllegalStateException("Le groupe avec l'identifiant "+ idGroupe + " n'existe pas");
        }
        groupeRepository.delete(idGroupe);

    }

    public GroupeDto getGroupeById(int idGroupe) {
        GroupeDto groupeDto = new GroupeDto();
      Groupe groupe= groupeRepository.findGroupeByIdGroupe(idGroupe);
      groupeDto.setAu(groupe.getAu());
      groupeDto.setNomGroupe(groupe.getNomGroupe());
      groupeDto.setIdGroupe(groupe.getIdGroupe());
      groupeDto.setDateCreation(String.valueOf(groupe.getDateCreation()));
      groupeDto.setIdDepartement(groupe.getDepartement().getIdDep());
      return groupeDto;

    }
}
