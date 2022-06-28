package com.iset_sfax.mini_projet.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

import static org.hibernate.type.descriptor.java.DateTypeDescriptor.DATE_FORMAT;

@Getter
@Setter
@NoArgsConstructor
public class EtudiantDto {

    private int id;
    private String nomEtd;
    private String prenomEtd;
    @ApiModelProperty(required = true,example = "2022-09-15")
    @JsonFormat(pattern = DATE_FORMAT)
    private String dateNaissanceEtd;
    private String photoEtd;
    private String adresseMailEtd;
    private String numInscription;
    private String password;
    @ApiModelProperty(required = true,example = "2022-09-15")
    @JsonFormat(pattern = DATE_FORMAT)
    private String dateInscription;
    private int au;
    private int idDepartement;
    private int idGroupe;
}
