package com.iset_sfax.mini_projet.services;

import com.iset_sfax.mini_projet.dto.EtudiantDto;
import com.iset_sfax.mini_projet.dto.post.EtudiantDtoPost;
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





    public void addnewEtudiant(EtudiantDtoPost etudiantDtoPost) throws NoSuchAlgorithmException {

        Optional<Etudiant> etudiantByEmail = etudiantRepository.findEtudiantByAdresseMailEtd(etudiantDtoPost.getAdresseMailEtd());
        if (etudiantByEmail.isPresent()){
            throw new IllegalStateException("Adresse email existante");
        }
        Etudiant etudiant = new Etudiant();
        etudiant.setNumEtd(etudiantDtoPost.getId());
        etudiant.setNomEtd(etudiantDtoPost.getNomEtd());
        etudiant.setPrenomEtd(etudiantDtoPost.getPrenomEtd());
        etudiant.setDateNaissanceEtd(LocalDate.parse(String.valueOf(etudiantDtoPost.getDateNaissanceEtd())));
        etudiant.setPhotoEtd(etudiantDtoPost.getPhotoEtd());
        etudiant.setAdresseMailEtd(etudiant.getAdresseMailEtd());
        etudiant.setNumInscription(etudiantDtoPost.getNumInscription());
        etudiant.setPassword(Util.toSha256(etudiantDtoPost.getPassword()));

        etudiant.setDateInscription(LocalDate.parse(String.valueOf(etudiantDtoPost.getDateInscription())));
        etudiant.setAu(etudiantDtoPost.getAu());
        etudiant.setDepartement(departementRepository.findDepartementByIdDep(etudiantDtoPost.getIdDepartement()));
        etudiant.setGroupe(groupeRepository.findGroupeByIdGroupe(etudiantDtoPost.getIdGroupe()));
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

    public void deleteEtudiant(int numEtd) {
        Optional<Etudiant> etudiantById = Optional.ofNullable(etudiantRepository.findEtudiantByNumEtd(numEtd));
        if(!etudiantById.isPresent()){
            throw new IllegalStateException("L'étudiant avec l'identifiant "+numEtd+" n'existe pas");
        }

        etudiantRepository.delete(numEtd);
    }
}
