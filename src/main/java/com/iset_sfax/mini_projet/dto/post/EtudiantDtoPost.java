package com.iset_sfax.mini_projet.dto.post;

import com.iset_sfax.mini_projet.dto.EtudiantDto;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.validator.constraints.NotBlank;
@Getter
@Setter
@NoArgsConstructor
public class EtudiantDtoPost extends EtudiantDto {


    @NotBlank(message = "Mote de passe etudiant est obligatoire")
    private String password;
}
