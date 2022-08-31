package com.iset_sfax.mini_projet.services;

import com.iset_sfax.mini_projet.dto.AssiduiteDto;
import com.iset_sfax.mini_projet.entities.Assiduite;
import com.iset_sfax.mini_projet.entities.SeanceCours;
import com.iset_sfax.mini_projet.repositories.AssiduiteRepository;
import com.iset_sfax.mini_projet.repositories.EtudiantRepository;
import com.iset_sfax.mini_projet.repositories.SeanceCoursRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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

    public List<Assiduite> getAssiduites() {
        return assiduiteRepository.findAll();
    }

    public void addNewAssiduite(AssiduiteDto assiduiteDto) {

        Assiduite assiduite = new Assiduite();
        assiduite.setEtudiant(etudiantRepository.findEtudiantByNumEtd(assiduiteDto.getIdEtudiant()));
        SeanceCours seanceCoursOptionalById = seanceCoursRepository.findSeanceCoursByIdSeance(assiduiteDto.getIdSeanceCours());
        if (seanceCoursOptionalById!=null){
            throw new IllegalStateException("Identifiant de séance cours non existant");
        }
        assiduite.setSeanceCours(seanceCoursOptionalById);
        assiduite.setAbsent(assiduiteDto.isAbsent());
        assiduite.setNoteTest(assiduiteDto.getNoteTest());
        assiduite.setRemarques(assiduiteDto.getRemarques());
        System.out.println(
                "this assiduite is "+
                assiduite.getAssiduiteId() +" "+
                assiduite.getEtudiant().getNomEtd() +" "+
                assiduite.getSeanceCours().getIdSeance() +" "+
                assiduite.isAbsent() +" "+
                assiduite.getNoteTest() +" "+
                assiduite.getRemarques());
        assiduiteRepository.save(assiduite);
    }

    public void deleteAssiduite(int assiduiteId) {
        Optional<Assiduite> assiduiteById = assiduiteRepository.findAssiduiteByAssiduiteId(assiduiteId);
        if (!assiduiteById.isPresent()) {
            throw new IllegalStateException("L'assiduite avec l'identfiant " + assiduiteId + " n'existe pas");
        }
        assiduiteRepository.delete(assiduiteId);
    }
}
