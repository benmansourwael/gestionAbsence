package com.iset_sfax.mini_projet.services;

import com.iset_sfax.mini_projet.entities.Departement;
import com.iset_sfax.mini_projet.repositories.DepartementRepository;
import com.iset_sfax.mini_projet.dto.DepartementDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
public class DepartementService {

    private final DepartementRepository departementRepository;

    @Autowired
    public DepartementService(DepartementRepository departementRepository) {
        this.departementRepository = departementRepository;
    }

    public List<DepartementDto> getDepartements() {
        List<DepartementDto> departementDtoList = new ArrayList<>();
        List<Departement>  departementList = departementRepository.findAll();

        for (Departement departement: departementList
             ) {
            DepartementDto departementDto = new DepartementDto();
            departementDto.setIdDep(departement.getIdDep());
            departementDto.setNomDep(departement.getNomDep());
            departementDto.setDateCreation(String.valueOf(departement.getDateCreation()));
            departementDtoList.add(departementDto);
        }
        return departementDtoList;
    }

    public void addNewDepartement(DepartementDto departementDto) {
        Departement departement = new Departement();
        departement.setIdDep(departementDto.getIdDep());
        departement.setNomDep(departementDto.getNomDep());
        departement.setDateCreation(LocalDate.parse(String.valueOf(departementDto.getDateCreation())));
        departementRepository.save(departement);
    }
}
