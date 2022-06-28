package com.iset_sfax.mini_projet.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class AssiduiteDto {

    private int idEtudiant;
    private int idSeanceCours;
    private boolean absent;
    private float noteTest;
    private String remarques;
}
