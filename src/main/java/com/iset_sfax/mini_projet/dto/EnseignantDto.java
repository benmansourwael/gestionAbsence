package com.iset_sfax.mini_projet.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.validator.constraints.NotBlank;

import static org.hibernate.type.descriptor.java.DateTypeDescriptor.DATE_FORMAT;

@Getter
@Setter
@NoArgsConstructor
public class EnseignantDto {
    private int numEns;

    @NotBlank(message = "Nom enseignant est obligatoire")
    private String nom;

    @NotBlank(message = "Prenom enseignant est obligatoire")
    private String prenom;

    @NotBlank(message = "Date de naissance enseignant est obligatoire")
    @ApiModelProperty(required = true, example = "2022-09-15")
    @JsonFormat(pattern = DATE_FORMAT)
    private String dateNaissance;

    private String photo;
    @NotBlank(message = "Email enseignant est obligatoire")
    private String adresseMailEns;

    @NotBlank(message = "Date embauche est obligatoire")
    @ApiModelProperty(required = true, example = "2022-09-15")
    @JsonFormat(pattern = DATE_FORMAT)
    private String dateEmbauche;

    @NotBlank(message = "Grade enseignant est obligatoire")
    private String grade;

    @NotBlank(message = "id departement est obligatoire")
    private int idDepartement;




}

