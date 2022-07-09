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



    @ManyToOne
    @JoinColumn(name="idDep")
    private Departement departement;


}
