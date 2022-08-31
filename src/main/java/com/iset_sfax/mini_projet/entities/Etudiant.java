package com.iset_sfax.mini_projet.entities;


import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Set;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Etudiant {
    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY )
    private int numEtd;
    private String nomEtd;
    private String prenomEtd;

    @JsonFormat(pattern="yyyy-MM-dd")
    private LocalDate dateNaissanceEtd;
    private String photoEtd;
    private String adresseMailEtd;
    private String numInscription;
    private String password;
    @JsonFormat(pattern="yyyy-MM-dd")
    private LocalDate dateInscription;
    private int au;
    @JsonIgnore
    @OneToMany(mappedBy = "etudiant", fetch = FetchType.LAZY)
    private Set<Assiduite> assiduites;

    @ManyToOne
    @JoinColumn(name="departement_id")
    private Departement departement;

    @ManyToOne
    @JoinColumn(name="groupe_id")
    private Groupe groupe;

}
