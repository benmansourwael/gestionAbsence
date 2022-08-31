package com.iset_sfax.mini_projet.util;
import com.iset_sfax.mini_projet.entities.Assiduite;
import com.iset_sfax.mini_projet.entities.Departement;
import com.iset_sfax.mini_projet.entities.Groupe;
import lombok.*;

import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@ToString
public class ValidUser {

    String prenom;

    String adresseEmail;


    String nom;
    boolean state;
    int id;

    int role;

    Departement departement;
    Groupe groupe;

    String photo;

    Set<Assiduite> assiduites;



    public ValidUser(String nom, String prenom, String adresseEmail, Departement departement, Groupe groupe, String photo, Set<Assiduite> assiduites, boolean state, int id, int role) {
        this.nom = nom;
        this.state = state;
        this.id = id;
        this.role = role;
        this.prenom = prenom;
        this.adresseEmail = adresseEmail;
        this.departement = departement;
        this.groupe = groupe;
        this.photo=photo;
        this.assiduites =  assiduites;
    }

}
