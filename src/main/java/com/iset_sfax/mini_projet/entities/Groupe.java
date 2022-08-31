package com.iset_sfax.mini_projet.entities;


import lombok.*;
import org.apache.tomcat.jni.Local;

import javax.persistence.*;
import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Groupe {
    @Id
    @GeneratedValue(
            strategy = GenerationType.IDENTITY
    )
    private int idGroupe;
    private String nomGroupe;
    private LocalDate dateCreation;
    private int au;



    @ManyToOne
    @JoinColumn(name="idDep")
    private Departement departement;

    public Groupe(int au, LocalDate dateCreation, String nomGroupe, Departement departement){
        this.au = au;
        this.dateCreation = dateCreation;
        this.nomGroupe = nomGroupe;
        this.departement = departement;
    }


}
