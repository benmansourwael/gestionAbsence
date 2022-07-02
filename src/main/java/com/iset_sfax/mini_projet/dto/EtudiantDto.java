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
public class EtudiantDto {

    private int id;

    @NotBlank(message = "Nom étudiant est obligatoire")
    private String nomEtd;

    @NotBlank(message = "Prénom étudiant est obligatoire")
    private String prenomEtd;

    @NotBlank(message = "Date naissance étudiant est obligatoire")
    @ApiModelProperty(required = true,example = "2022-09-15")
    @JsonFormat(pattern = DATE_FORMAT)
    private String dateNaissanceEtd;

    private String photoEtd;

    @NotBlank(message = "Adresse email  étudiant est obligatoire")
    private String adresseMailEtd;


    private String numInscription;

    @ApiModelProperty(required = true,example = "2022-09-15")
    @JsonFormat(pattern = DATE_FORMAT)
    private String dateInscription;
    private int au;
    private int idDepartement;
    private int idGroupe;

}
