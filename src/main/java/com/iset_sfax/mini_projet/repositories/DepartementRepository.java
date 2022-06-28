package com.iset_sfax.mini_projet.repositories;

import com.iset_sfax.mini_projet.entities.Departement;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DepartementRepository extends JpaRepository<Departement, Integer> {
    Departement findDepartementByIdDep(int id);
}
