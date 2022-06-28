package com.iset_sfax.mini_projet.repositories;

import com.iset_sfax.mini_projet.entities.SeanceCours;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SeanceCoursRepository extends JpaRepository<SeanceCours, Integer> {
    SeanceCours findSeanceCoursByIdSeance(int id);
}
