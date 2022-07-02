package com.iset_sfax.mini_projet.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.validator.constraints.NotBlank;

@Getter
@Setter
@NoArgsConstructor
public class AssiduiteDto {

    private int idEtudiant;
    @NotBlank(message = "Id seance cours est obligatoire")
    private int idSeanceCours;
    @NotBlank(message = "l'absence est obligatoire")
    private boolean absent;

    private float noteTest;
    private String remarques;
}
