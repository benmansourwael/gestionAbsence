package com.iset_sfax.mini_projet.entities;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

@NoArgsConstructor
@AllArgsConstructor
@Embeddable
@EqualsAndHashCode
public class AssiduiteComposedKey implements Serializable {

    @Column(name = "numEtd")
    private int numEtd;

    @Column(name = "num_inscription")
    private int num_inscription;

}