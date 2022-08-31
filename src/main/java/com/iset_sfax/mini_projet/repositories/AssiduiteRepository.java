package com.iset_sfax.mini_projet.repositories;
import com.iset_sfax.mini_projet.entities.Assiduite;
import com.iset_sfax.mini_projet.entities.Etudiant;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface AssiduiteRepository extends JpaRepository<Assiduite,Integer> {
     Optional<Assiduite> findAssiduiteByAssiduiteId(int assiduite_id);

     List<Assiduite> findAssiduitesByEtudiant(Etudiant etudiant);
}
