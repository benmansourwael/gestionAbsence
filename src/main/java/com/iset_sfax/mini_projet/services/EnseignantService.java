package com.iset_sfax.mini_projet.services;

import com.iset_sfax.mini_projet.dto.EnseignantDto;
import com.iset_sfax.mini_projet.dto.post.EnseignantDtoPost;
import com.iset_sfax.mini_projet.entities.Departement;
import com.iset_sfax.mini_projet.entities.Enseignant;
import com.iset_sfax.mini_projet.repositories.DepartementRepository;
import com.iset_sfax.mini_projet.repositories.EnseignantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

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
        List<EnseignantDto> enseignantDtoPostList = new ArrayList<>();
        for (Enseignant enseignant:enseignantList
             ) {

            EnseignantDto enseignantDtoPost = new EnseignantDto();
            enseignantDtoPost.setNumEns(enseignant.getNumEns());
            enseignantDtoPost.setNom(enseignant.getNom());
            enseignantDtoPost.setPrenom(enseignant.getPrenom());
            enseignantDtoPost.setDateNaissance(String.valueOf(enseignant.getDateNaissance()));
            enseignantDtoPost.setPhoto(enseignant.getPhoto());
            enseignantDtoPost.setAdresseMailEns(enseignant.getAdresseMailEns());
            enseignantDtoPost.setDateEmbauche(String.valueOf(enseignant.getDateEmbauche()));
            enseignantDtoPost.setGrade(enseignant.getGrade());
            enseignantDtoPost.setIdDepartement(enseignant.getDepartement().getIdDep());
            enseignantDtoPostList.add(enseignantDtoPost);

        }

        return enseignantDtoPostList;

    }

    public void addnewEnseignant(EnseignantDtoPost enseignantDtoPost) {
        Optional<Enseignant> enseignantByEmail = enseignantRepository.findEnseignantByAdresseMailEns(enseignantDtoPost.getAdresseMailEns());
        if (enseignantByEmail.isPresent()){
            throw new IllegalStateException("Adresse email existante");
        }
        Enseignant enseignant= new Enseignant();
        enseignant.setNumEns(enseignantDtoPost.getNumEns());
        enseignant.setNom(enseignantDtoPost.getNom());
        enseignant.setPrenom(enseignantDtoPost.getPrenom());
        enseignant.setDateNaissance(LocalDate.parse(String.valueOf(enseignantDtoPost.getDateNaissance())));
        enseignant.setPhoto(enseignantDtoPost.getPhoto());
        enseignant.setAdresseMailEns(enseignantDtoPost.getAdresseMailEns());
        enseignant.setDateEmbauche(LocalDate.parse(String.valueOf(enseignantDtoPost.getDateEmbauche())));
        enseignant.setGrade(enseignantDtoPost.getGrade());
        enseignant.setPassword(enseignantDtoPost.getPassword());

        Optional<Departement> optionalDepartement = Optional.ofNullable(departementRepository.findDepartementByIdDep(enseignantDtoPost.getIdDepartement()));
        if (optionalDepartement.isPresent())
            enseignant.setDepartement(optionalDepartement.get());
        else throw new IllegalStateException("Id du departement inexistant");
        enseignantRepository.save(enseignant);
    }

    public void deleteEnseignant(int numEns) {
        Optional<Enseignant> enseignantById = Optional.ofNullable(enseignantRepository.findEnseignantByNumEns(numEns));
        if(!enseignantById.isPresent()){
            throw new IllegalStateException("L'enseignant avec l'identifiant "+ numEns +" n'existe pas");
        }
        enseignantRepository.delete(numEns);

    }
}
