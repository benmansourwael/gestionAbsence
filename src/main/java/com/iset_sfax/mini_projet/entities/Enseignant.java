package com.iset_sfax.mini_projet.entities;


import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.validator.constraints.NotBlank;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Enseignant {
    @Id
    @GeneratedValue(
            strategy = GenerationType.IDENTITY

    )

    private int numEns;

    private String nom;

    private String prenom;


    private String password;

    private LocalDate dateNaissance;
    private String photo;


    private String adresseMailEns;

    private LocalDate dateEmbauche;


    private String grade;
    @JsonIgnore
    @OneToMany(mappedBy = "enseignant", fetch = FetchType.LAZY)
    private List<SeanceCours> seancescours;


    @ManyToOne
    @JoinColumn(name = "departement_id")
    private Departement departement;

}
