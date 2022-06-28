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
public class GroupeDto {
    private int idGroupe;
    private String nomGroupe;
    @ApiModelProperty(required = true,example = "2022-09-15")
    @JsonFormat(pattern = DATE_FORMAT)
    private String dateCreation;
    private int au;
    private int idDepartement;
}
