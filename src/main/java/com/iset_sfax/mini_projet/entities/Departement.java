package com.iset_sfax.mini_projet.entities;


import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.annotations.ApiParam;
import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

import static org.hibernate.type.descriptor.java.DateTypeDescriptor.DATE_FORMAT;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Departement {

    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY )

    private int idDep;
    private String nomDep;


    private LocalDate dateCreation;
    @JsonIgnore
    @OneToMany(mappedBy = "departement", fetch = FetchType.LAZY)
    private List<Enseignant> enseignants;
    @JsonIgnore
    @OneToMany(mappedBy = "departement", fetch = FetchType.LAZY)
    private List<Groupe> groupes;
    @JsonIgnore
    @OneToMany(mappedBy = "departement", fetch = FetchType.LAZY)
    private List<Etudiant> etudiants;

    public Departement(String nomDep, LocalDate dateCreation, List<Enseignant> enseignants, List<Groupe> groupes, List<Etudiant> etudiants) {
        this.nomDep = nomDep;
        this.dateCreation = dateCreation;
        this.enseignants = enseignants;
        this.groupes = groupes;
        this.etudiants = etudiants;
    }

    public Departement(String nomDep, LocalDate dateCreation){
        this.nomDep = nomDep;
        this.dateCreation = dateCreation;
    }
//    public Departement(int idDep, String nomDep, LocalDate dateCreation) {
//        this.idDep = idDep;
//        this.nomDep = nomDep;
//        this.dateCreation = dateCreation;
//    }

}
