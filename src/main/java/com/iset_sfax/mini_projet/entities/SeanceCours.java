package com.iset_sfax.mini_projet.entities;

import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class SeanceCours {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY )
    private int idSeance;
    private String dateJour;
    private int CreneauHoraire;
    private boolean testEvaluation;


    @ManyToOne
    @JoinColumn(name = "enseignant_id")
    private Enseignant enseignant;

    @ManyToOne
    @JoinColumn(name = "matiere_id")
    private Matiere matiere;

    @ManyToOne
    @JoinColumn(name = "groupe_id")
    private Groupe groupe;

}

