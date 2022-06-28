package com.iset_sfax.mini_projet.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class MatiereDto {
    private int idMat;
    private String nomMat;
    private float coefMat;
    private float nbreHeureCours;
    private float nbreHeureTP;

}
