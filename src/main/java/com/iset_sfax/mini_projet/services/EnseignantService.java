package com.iset_sfax.mini_projet.services;

import com.iset_sfax.mini_projet.dto.EnseignantDto;
import com.iset_sfax.mini_projet.entities.Enseignant;
import com.iset_sfax.mini_projet.repositories.DepartementRepository;
import com.iset_sfax.mini_projet.repositories.EnseignantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
public class EnseignantService {

    private final EnseignantRepository enseignantRepository;
    private final DepartementRepository departementRepository;

    @Autowired
    public EnseignantService(EnseignantRepository enseignantRepository, DepartementRepository departementRepository) {
        this.enseignantRepository = enseignantRepository;
        this.departementRepository = departementRepository;
    }

    public List<EnseignantDto> getEnseignants(){

        List<Enseignant> enseignantList = enseignantRepository.findAll();
        List<EnseignantDto> enseignantDtoList = new ArrayList<>();
        for (Enseignant enseignant:enseignantList
             ) {
            EnseignantDto enseignantDto = new EnseignantDto();
            enseignantDto.setNumEns(enseignant.getNumEns());
            enseignantDto.setNom(enseignant.getNom());
            enseignantDto.setPrenom(enseignant.getPrenom());
            enseignantDto.setDateNaissance(String.valueOf(enseignant.getDateNaissance()));
            enseignantDto.setPhoto(enseignant.getPhoto());
            enseignantDto.setAdresseMailEns(enseignant.getAdresseMailEns());
            enseignantDto.setDateEmbauche(String.valueOf(enseignant.getDateEmbauche()));
            enseignantDto.setGrade(enseignant.getGrade());
            enseignantDto.setIdDepartement(enseignant.getDepartement().getIdDep());
            enseignantDtoList.add(enseignantDto);

        }

        return enseignantDtoList;

    }

    public void addnewEnseignant(EnseignantDto enseignantDto) {
        Enseignant enseignant= new Enseignant();
        enseignant.setNumEns(enseignantDto.getNumEns());
        enseignant.setNom(enseignantDto.getNom());
        enseignant.setPrenom(enseignantDto.getPrenom());
        enseignant.setDateNaissance(LocalDate.parse(String.valueOf(enseignantDto.getDateNaissance())));
        enseignant.setPhoto(enseignantDto.getPhoto());
        enseignant.setAdresseMailEns(enseignantDto.getAdresseMailEns());
        enseignant.setDateEmbauche(LocalDate.parse(String.valueOf(enseignantDto.getDateEmbauche())));
        enseignant.setGrade(enseignantDto.getGrade());
        enseignant.setDepartement(departementRepository.findDepartementByIdDep(enseignantDto.getIdDepartement()));


        enseignantRepository.save(enseignant);
    }
}
