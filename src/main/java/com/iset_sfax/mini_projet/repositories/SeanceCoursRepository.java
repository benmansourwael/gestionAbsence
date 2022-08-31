package com.iset_sfax.mini_projet.repositories;

import com.iset_sfax.mini_projet.dto.SeanceCoursDto;
import com.iset_sfax.mini_projet.entities.SeanceCours;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface SeanceCoursRepository extends JpaRepository<SeanceCours, Integer> {
    SeanceCours findSeanceCoursByIdSeance(int id);

    @Query( value = "SELECT groupe_id FROM seance_cours ORDER BY id_seance ASC LIMIT 1" , nativeQuery = true)
    int findFirstElement();



}
