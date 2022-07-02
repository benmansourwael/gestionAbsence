package com.iset_sfax.mini_projet.dto.post;

import com.iset_sfax.mini_projet.dto.EnseignantDto;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.validator.constraints.NotBlank;

@Getter
@Setter
@NoArgsConstructor
public class EnseignantDtoPost extends EnseignantDto {

    @NotBlank(message = "Mote de passe enseignant est obligatoire")
    private String password;

}
