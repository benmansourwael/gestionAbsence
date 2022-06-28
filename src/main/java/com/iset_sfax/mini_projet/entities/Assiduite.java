package com.iset_sfax.mini_projet.entities;


import lombok.*;

import javax.persistence.*;


@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
public class Assiduite {


//    @EmbeddedId
//    AssiduiteComposedKey id;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int assiduite_id;


    @ManyToOne
    @JoinColumn(name = "numEtd")
        private Etudiant etudiant;

    @ManyToOne
    @JoinColumn(name = "idSeance")
    private SeanceCours seanceCours;




    private boolean absent;
    private float noteTest;
    private String remarques;







}


