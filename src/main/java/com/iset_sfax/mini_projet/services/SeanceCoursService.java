package com.iset_sfax.mini_projet.services;

import com.iset_sfax.mini_projet.dto.SeanceCoursDto;
import com.iset_sfax.mini_projet.entities.Assiduite;
import com.iset_sfax.mini_projet.entities.SeanceCours;
import com.iset_sfax.mini_projet.repositories.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class SeanceCoursService {

    private final SeanceCoursRepository seanceCoursRepository;
    private final EnseignantRepository enseignantRepository;
    private final MatiereRepository matiereRepository;
    private final GroupeRepository groupeRepository;

    private final EtudiantRepository etudiantRepository;
    private final AssiduiteRepository assiduiteRepository;


    @Autowired
    public SeanceCoursService(SeanceCoursRepository seanceCoursRepository, EnseignantRepository enseignantRepository, MatiereRepository matiereRepository, GroupeRepository groupeRepository, EtudiantRepository etudiantRepository, AssiduiteRepository assiduiteRepository) {
        this.seanceCoursRepository = seanceCoursRepository;
        this.enseignantRepository = enseignantRepository;
        this.matiereRepository = matiereRepository;
        this.groupeRepository = groupeRepository;
        this.etudiantRepository = etudiantRepository;
        this.assiduiteRepository = assiduiteRepository;
    }


    public List<SeanceCoursDto> getSeancesCours(){

        List<SeanceCours> seanceCoursList= seanceCoursRepository.findAll();
        List<SeanceCoursDto> seanceCoursDtos = new ArrayList<>();
        for (SeanceCours seancecours: seanceCoursList ) {
            SeanceCoursDto seanceCoursDto = new SeanceCoursDto();
            seanceCoursDto.setIdSeance(seancecours.getIdSeance());
            seanceCoursDto.setCreneauHoraire(seancecours.getCreneauHoraire());
            seanceCoursDto.setIdGroupe(seancecours.getGroupe().getIdGroupe());
            seanceCoursDto.setIdMatiere(seancecours.getMatiere().getIdMat());
            seanceCoursDto.setIdEnseignant(seancecours.getEnseignant().getNumEns());
            seanceCoursDto.setDateJour(seancecours.getDateJour());
            seanceCoursDto.setTestEvaluation(seancecours.isTestEvaluation());
            seanceCoursDtos.add(seanceCoursDto);
        }
        return seanceCoursDtos;

    }

    public void addNewSeanceCours(SeanceCoursDto seanceCoursDto) {
        SeanceCours seanceCours = new SeanceCours();
        seanceCours.setIdSeance(seanceCoursDto.getIdMatiere());
        seanceCours.setDateJour(seanceCoursDto.getDateJour());
        seanceCours.setCreneauHoraire(seanceCours.getCreneauHoraire());
        seanceCours.setTestEvaluation(seanceCoursDto.isTestEvaluation());
        seanceCours.setEnseignant(enseignantRepository.findEnseignantByNumEns(seanceCoursDto.getIdEnseignant()));
        seanceCours.setMatiere(matiereRepository.findMatiereByIdMat(seanceCoursDto.getIdMatiere()));
        seanceCours.setGroupe(groupeRepository.findGroupeByIdGroupe(seanceCoursDto.getIdGroupe()));
        seanceCoursRepository.save(seanceCours);
    }

    public void deleteSeanceCours(int idSeance) {
        SeanceCours seanceCoursById = seanceCoursRepository.findSeanceCoursByIdSeance(idSeance);
        if(seanceCoursById!=null){
            throw new IllegalStateException("La seance de cours avec l'identifiant "+idSeance + " n'existe pas");
        }
        seanceCoursRepository.delete(idSeance);
    }

    public List<SeanceCoursDto> getSeancesCoursByEtudiantId(int etudiantId) {
        List<Assiduite> assiduiteList = assiduiteRepository.findAssiduitesByEtudiant(etudiantRepository.findEtudiantByNumEtd(etudiantId));
        List<SeanceCoursDto> seanceCoursList = new ArrayList<>();
        for (Assiduite assiduite:assiduiteList) {
            SeanceCoursDto seanceCoursDto = new SeanceCoursDto();
            seanceCoursDto.setIdSeance(assiduite.getSeanceCours().getIdSeance());
            seanceCoursDto.setCreneauHoraire(assiduite.getSeanceCours().getCreneauHoraire());
            seanceCoursDto.setIdGroupe(assiduite.getSeanceCours().getGroupe().getIdGroupe());
            seanceCoursDto.setIdMatiere(assiduite.getSeanceCours().getMatiere().getIdMat());
            seanceCoursDto.setIdEnseignant(assiduite.getSeanceCours().getEnseignant().getNumEns());
            seanceCoursDto.setDateJour(assiduite.getSeanceCours().getDateJour());
            seanceCoursDto.setTestEvaluation(assiduite.getSeanceCours().isTestEvaluation());
            seanceCoursList.add(seanceCoursDto);
        }
        return seanceCoursList;



    }

    public SeanceCoursDto getSeanceCoursById(int idSeance) {
        SeanceCours seanceCours = seanceCoursRepository.findSeanceCoursByIdSeance(idSeance);
        SeanceCoursDto seanceCoursDto = new SeanceCoursDto();
        seanceCoursDto.setIdSeance(seanceCours.getIdSeance());
        seanceCoursDto.setCreneauHoraire(seanceCours.getCreneauHoraire());
        seanceCoursDto.setIdGroupe(seanceCours.getGroupe().getIdGroupe());
        seanceCoursDto.setIdMatiere(seanceCours.getMatiere().getIdMat());
        seanceCoursDto.setIdEnseignant(seanceCours.getEnseignant().getNumEns());
        seanceCoursDto.setDateJour(seanceCours.getDateJour());
        seanceCoursDto.setTestEvaluation(seanceCours.isTestEvaluation());
        return seanceCoursDto;

    }

    public SeanceCoursDto getSeanceCourIndex0() {
        SeanceCours seanceCours =  seanceCoursRepository.findFirstElement();
        SeanceCoursDto seanceCoursDto = new SeanceCoursDto();
        seanceCoursDto.setIdSeance(seanceCours.getIdSeance());
        seanceCoursDto.setCreneauHoraire(seanceCours.getCreneauHoraire());
        seanceCoursDto.setIdGroupe(seanceCours.getGroupe().getIdGroupe());
        seanceCoursDto.setIdMatiere(seanceCours.getMatiere().getIdMat());
        seanceCoursDto.setIdEnseignant(seanceCours.getEnseignant().getNumEns());
        seanceCoursDto.setDateJour(seanceCours.getDateJour());
        seanceCoursDto.setTestEvaluation(seanceCours.isTestEvaluation());
        return seanceCoursDto;
    }
}
