package com.iset_sfax.mini_projet.services;

import com.iset_sfax.mini_projet.dto.EtudiantDto;
import com.iset_sfax.mini_projet.entities.Etudiant;
import com.iset_sfax.mini_projet.repositories.DepartementRepository;
import com.iset_sfax.mini_projet.repositories.EtudiantRepository;
import com.iset_sfax.mini_projet.repositories.GroupeRepository;
import com.iset_sfax.mini_projet.util.Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.security.NoSuchAlgorithmException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class EtudiantService {

    private final EtudiantRepository etudiantRepository;
    private final GroupeRepository groupeRepository;
    private final DepartementRepository departementRepository;


    @Autowired
    public EtudiantService(EtudiantRepository etudiantRepository, GroupeRepository groupeRepository, DepartementRepository departementRepository) {
        this.etudiantRepository = etudiantRepository;

        this.groupeRepository = groupeRepository;
        this.departementRepository = departementRepository;
    }





    public void addnewEtudiant(EtudiantDto etudiantDto) throws NoSuchAlgorithmException {

        Optional<Etudiant> etudiantByEmail = etudiantRepository.findEtudiantByAdresseMailEtd(etudiantDto.getAdresseMailEtd());
        if (etudiantByEmail.isPresent()){
            throw new IllegalStateException("Adresse email existante");
        }
        Etudiant etudiant = new Etudiant();
        etudiant.setNumEtd(etudiantDto.getId());
        etudiant.setNomEtd(etudiantDto.getNomEtd());
        etudiant.setPrenomEtd(etudiantDto.getPrenomEtd());
        etudiant.setDateNaissanceEtd(LocalDate.parse(String.valueOf(etudiantDto.getDateNaissanceEtd())));
        etudiant.setPhotoEtd(etudiantDto.getPhotoEtd());
        etudiant.setAdresseMailEtd(etudiant.getAdresseMailEtd());
        etudiant.setNumInscription(etudiantDto.getNumInscription());
        etudiant.setPassword(Util.toSha256(etudiantDto.getPassword()));

        etudiant.setDateInscription(LocalDate.parse(String.valueOf(etudiantDto.getDateInscription())));
        etudiant.setAu(etudiantDto.getAu());
        etudiant.setDepartement(departementRepository.findDepartementByIdDep(etudiantDto.getIdDepartement()));
        etudiant.setGroupe(groupeRepository.findGroupeByIdGroupe(etudiantDto.getIdGroupe()));
        etudiantRepository.save(etudiant);
    }
    public List<EtudiantDto> getEtudiants(){


        List<EtudiantDto> etudiantDtos = new ArrayList<>();

        List<Etudiant> etudiantList = etudiantRepository.findAll();

        for (Etudiant etudiant: etudiantList
        ) {
            EtudiantDto etudiantDto = new EtudiantDto();
            etudiantDto.setId(etudiant.getNumEtd());
            etudiantDto.setNomEtd(etudiant.getNomEtd());
            etudiantDto.setPrenomEtd(etudiant.getPrenomEtd());
            etudiantDto.setDateNaissanceEtd(String.valueOf(etudiant.getDateNaissanceEtd()));
            etudiantDto.setPhotoEtd(etudiant.getPhotoEtd());
            etudiantDto.setAdresseMailEtd(etudiant.getAdresseMailEtd());
            etudiantDto.setNumInscription(etudiant.getNumInscription());
            etudiantDto.setDateInscription(String.valueOf(etudiant.getDateInscription()));
            etudiantDto.setAu(etudiant.getAu());
            etudiantDto.setIdDepartement(etudiant.getDepartement().getIdDep());
            etudiantDto.setIdGroupe(etudiant.getGroupe().getIdGroupe());
            etudiantDtos.add(etudiantDto);




        }

        return etudiantDtos;

    }
    public List<Etudiant> getEtudiantsByGroupName(String GroupeName) {

        return etudiantRepository.findEtudiantsByGroupe(groupeRepository.findGroupeByNomGroupe(GroupeName));
    }
}
