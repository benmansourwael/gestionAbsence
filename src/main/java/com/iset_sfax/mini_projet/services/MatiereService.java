package com.iset_sfax.mini_projet.services;

import com.iset_sfax.mini_projet.dto.MatiereDto;
import com.iset_sfax.mini_projet.entities.Matiere;
import com.iset_sfax.mini_projet.repositories.MatiereRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MatiereService {

    private final MatiereRepository matiereRepository;

    @Autowired
    public MatiereService(MatiereRepository matiereRepository) {
        this.matiereRepository = matiereRepository;
    }

    public List<Matiere> getMatieres(){

        return matiereRepository.findAll();
    }

    public void addNewMatiere(MatiereDto matiereDto) {
        Matiere matiere = new Matiere();
        matiere.setIdMat(matiereDto.getIdMat());
        matiere.setNomMat(matiereDto.getNomMat());
        matiere.setCoefMat(matiereDto.getCoefMat());
        matiere.setNbreHeureTP(matiereDto.getNbreHeureTP());
        matiere.setNbreHeureCours(matiereDto.getNbreHeureCours());
        matiereRepository.save(matiere);
    }
}
