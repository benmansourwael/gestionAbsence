package com.iset_sfax.mini_projet.controllers;

import com.iset_sfax.mini_projet.entities.Enseignant;
import com.iset_sfax.mini_projet.entities.Etudiant;
import com.iset_sfax.mini_projet.repositories.EnseignantRepository;
import com.iset_sfax.mini_projet.repositories.EtudiantRepository;
import com.iset_sfax.mini_projet.util.Credentials;
import com.iset_sfax.mini_projet.util.Util;
import com.iset_sfax.mini_projet.util.ValidUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.security.NoSuchAlgorithmException;
import java.util.Optional;

@RestController
@CrossOrigin
@RequestMapping(path = "/api/authentification")
public class AuthenticationController {

    @Autowired
    private EtudiantRepository etudiantRepository;

    @Autowired
    private EnseignantRepository enseignantRepository;

    @PostMapping
    public ValidUser authentification(@RequestBody Credentials credentials) throws NoSuchAlgorithmException {
        String email = credentials.getEmail();
        String pswd = credentials.getPswd();

        Optional<Etudiant> optionalEtudiant =etudiantRepository.findEtudiantByAdresseMailEtdAndPassword(email,  Util.toSha256(pswd));
        Optional<Enseignant> optionalEnseignant = enseignantRepository.findEnseignantByAdresseMailEnsAndPassword(email, pswd);
        if(optionalEtudiant.isPresent()) {
            Etudiant u= optionalEtudiant.get();
            return new ValidUser(u.getNomEtd(), true, u.getNumEtd(),3);
        }
        if(optionalEnseignant.isPresent()) {
            Enseignant u= optionalEnseignant.get();
            return new ValidUser(u.getNom(), true, u.getNumEns(),2);
        }

        return new ValidUser("",false,0,0);
    }

}
