package com.iset_sfax.mini_projet.entities;


import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

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
    @JoinColumn(name="departement_id")
    private Departement departement;

    public Enseignant(String nom, String prenom, LocalDate dateNaissance, String photo, String adresseMailEns, LocalDate dateEmbauche, String grade, List<SeanceCours> seancescours, Departement departement) {
        this.nom = nom;
        this.prenom = prenom;
        this.dateNaissance = dateNaissance;
        this.photo = photo;
        this.adresseMailEns = adresseMailEns;
        this.dateEmbauche = dateEmbauche;
        this.grade = grade;
        this.seancescours = seancescours;
        this.departement = departement;
    }
}
