package com.iset_sfax.mini_projet.repositories;

import com.iset_sfax.mini_projet.entities.Etudiant;
import com.iset_sfax.mini_projet.entities.Groupe;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface EtudiantRepository extends JpaRepository<Etudiant,Integer> {


    Optional<Etudiant> findEtudiantByAdresseMailEtd(String adresseMailEtd);
    Etudiant findEtudiantByNumEtd(int id);

    List<Etudiant> findEtudiantsByGroupe(Groupe groupe);

    Optional<Etudiant> findEtudiantByAdresseMailEtdAndPassword(String adresseMailEtd,String password );









}
