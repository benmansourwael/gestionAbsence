package com.iset_sfax.mini_projet.repositories;


import com.iset_sfax.mini_projet.entities.Enseignant;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface EnseignantRepository extends JpaRepository<Enseignant, Integer> {
    Enseignant findEnseignantByNumEns(int id);

    Optional <Enseignant> findEnseignantByAdresseMailEns(String adresseMailEns);

    Optional<Enseignant> findEnseignantByAdresseMailEnsAndPassword(String adresseMailEns,String password);
}
