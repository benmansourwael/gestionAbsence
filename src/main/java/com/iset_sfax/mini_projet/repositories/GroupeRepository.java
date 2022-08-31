package com.iset_sfax.mini_projet.repositories;

import com.iset_sfax.mini_projet.entities.Groupe;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface GroupeRepository extends JpaRepository<Groupe, Integer> {
    Groupe findGroupeByIdGroupe(int idGroupe);
    Groupe findGroupeByNomGroupe(String nomGroup);



}
