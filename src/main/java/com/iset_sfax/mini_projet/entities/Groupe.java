package com.iset_sfax.mini_projet.entities;


import lombok.*;

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
//    @JsonIgnore
//    @OneToMany(fetch = FetchType.LAZY)
//    @JoinColumn(name = "numEtd")
//    private List<Etudiant> etudiants;
//    @JsonIgnore
//    @OneToMany(fetch = FetchType.LAZY)
//    @JoinColumn(name = "idSeance")
//    private List<SeanceCours> seancescours;


    @ManyToOne
    @JoinColumn(name="departement_id")
    private Departement departement;


//    public Groupe(String nomGroupe, LocalDate dateCreation, int au, Departement departement) {
//        this.nomGroupe = nomGroupe;
//        this.dateCreation = dateCreation;
//        this.au = au;
//        this.departement = departement;
//    }
}
