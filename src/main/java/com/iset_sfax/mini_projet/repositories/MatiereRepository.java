package com.iset_sfax.mini_projet.repositories;

import com.iset_sfax.mini_projet.entities.Matiere;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MatiereRepository extends JpaRepository<Matiere, Integer> {
    Matiere findMatiereByIdMat(int id);
}
