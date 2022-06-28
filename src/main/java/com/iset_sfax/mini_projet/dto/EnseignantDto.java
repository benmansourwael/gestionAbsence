package com.iset_sfax.mini_projet.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import static org.hibernate.type.descriptor.java.DateTypeDescriptor.DATE_FORMAT;

@Getter
@Setter
@NoArgsConstructor
public class EnseignantDto {
    private int numEns;
    private String nom;
    private String prenom;
    @ApiModelProperty(required = true,example = "2022-09-15")
    @JsonFormat(pattern = DATE_FORMAT)
    private String dateNaissance;
    private String photo;
    private String adresseMailEns;
    @ApiModelProperty(required = true,example = "2022-09-15")
    @JsonFormat(pattern = DATE_FORMAT)
    private String dateEmbauche;
    private String grade;
    private int idDepartement;
}
