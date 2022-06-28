package com.iset_sfax.mini_projet.util;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@ToString
public class ValidUser {

    String nom;
    boolean state;
    int id;

    int role;


    public ValidUser(String nom, boolean state, int id, int role) {
        this.nom = nom;
        this.state = state;
        this.id = id;
        this.role = role;
    }

}
