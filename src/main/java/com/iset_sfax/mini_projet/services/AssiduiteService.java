package com.iset_sfax.mini_projet.services;

import com.iset_sfax.mini_projet.dto.AssiduiteDto;
import com.iset_sfax.mini_projet.entities.Assiduite;
import com.iset_sfax.mini_projet.repositories.AssiduiteRepository;
import com.iset_sfax.mini_projet.repositories.EtudiantRepository;
import com.iset_sfax.mini_projet.repositories.SeanceCoursRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class AssiduiteService {

    private final AssiduiteRepository assiduiteRepository;
    private final EtudiantRepository etudiantRepository;
    private final SeanceCoursRepository seanceCoursRepository;

    @Autowired
    public AssiduiteService(AssiduiteRepository assiduiteRepository, EtudiantRepository etudiantRepository, SeanceCoursRepository seanceCoursRepository) {
        this.assiduiteRepository = assiduiteRepository;
        this.etudiantRepository = etudiantRepository;
        this.seanceCoursRepository = seanceCoursRepository;
    }

    public List<Assiduite> getAssiduites(){
        return assiduiteRepository.findAll();
    }

    public void addNewAssiduite(AssiduiteDto assiduiteDto) {

        Assiduite assiduite = new Assiduite();
        assiduite.setEtudiant(etudiantRepository.findEtudiantByNumEtd(assiduiteDto.getIdEtudiant()));
        assiduite.setSeanceCours(seanceCoursRepository.findSeanceCoursByIdSeance(assiduiteDto.getIdSeanceCours()));
        assiduite.setAbsent(assiduiteDto.isAbsent());
        assiduite.setNoteTest(assiduiteDto.getNoteTest());
        assiduite.setRemarques(assiduiteDto.getRemarques());
        assiduiteRepository.save(assiduite);
    }
}
