package com.iset_sfax.mini_projet.entities;


import lombok.*;

import javax.persistence.*;
import java.io.Serializable;


@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
public class Assiduite implements Serializable {


//    @EmbeddedId
//    AssiduiteComposedKey id;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int assiduiteId;

    //    @NotBlank(message = "id etudiant est obligatoire")
    @ManyToOne
    @JoinColumn(name = "numEtd")
    private Etudiant etudiant;

    //    @NotBlank(message = "id etudiant est obligatoire")
    @ManyToOne
    @JoinColumn(name = "idSeance")
    private SeanceCours seanceCours;


    private boolean absent;
    private float noteTest;
    private String remarques;


}


