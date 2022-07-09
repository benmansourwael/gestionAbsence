package com.iset_sfax.mini_projet.entities;


import lombok.*;

import javax.persistence.*;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Matiere  {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY )
    private int idMat;
    private String nomMat;
    private float coefMat;
    private float nbreHeureCours;
    @Column(name = "nbre_heure_TP")
    private float nbreHeureTP;


}
