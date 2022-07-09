package com.iset_sfax.mini_projet.services;

import com.iset_sfax.mini_projet.dto.SeanceCoursDto;
import com.iset_sfax.mini_projet.entities.SeanceCours;
import com.iset_sfax.mini_projet.repositories.EnseignantRepository;
import com.iset_sfax.mini_projet.repositories.GroupeRepository;
import com.iset_sfax.mini_projet.repositories.MatiereRepository;
import com.iset_sfax.mini_projet.repositories.SeanceCoursRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;

@Service
public class SeanceCoursService {

    private final SeanceCoursRepository seanceCoursRepository;
    private final EnseignantRepository enseignantRepository;
    private final MatiereRepository matiereRepository;
    private final GroupeRepository groupeRepository;


    @Autowired
    public SeanceCoursService(SeanceCoursRepository seanceCoursRepository, EnseignantRepository enseignantRepository, MatiereRepository matiereRepository, GroupeRepository groupeRepository) {
        this.seanceCoursRepository = seanceCoursRepository;
        this.enseignantRepository = enseignantRepository;
        this.matiereRepository = matiereRepository;
        this.groupeRepository = groupeRepository;
    }


    public List<SeanceCours> getSeancesCours(){

        return seanceCoursRepository.findAll();
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
        Optional<SeanceCours> seanceCoursById = seanceCoursRepository.findSeanceCoursByIdSeance(idSeance);
        if(!seanceCoursById.isPresent()){
            throw new IllegalStateException("La seance de cours avec l'identifiant "+idSeance + " n'existe pas");
        }
        seanceCoursRepository.delete(idSeance);
    }
}
