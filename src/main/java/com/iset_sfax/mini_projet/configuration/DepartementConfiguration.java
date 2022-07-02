//package com.iset_sfax.mini_projet.configuration;
//
//
//import com.iset_sfax.mini_projet.entities.Departement;
//import com.iset_sfax.mini_projet.entities.Enseignant;
//import com.iset_sfax.mini_projet.entities.Etudiant;
//import com.iset_sfax.mini_projet.entities.Groupe;
//import com.iset_sfax.mini_projet.repositories.DepartementRepository;
//import org.springframework.boot.CommandLineRunner;
//import org.springframework.boot.autoconfigure.AutoConfigureOrder;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//
//import java.time.LocalDate;
//import java.util.ArrayList;
//import java.util.List;
//
//@Configuration
//@AutoConfigureOrder(1)
//public class DepartementConfiguration {
//
//    @Bean
//    CommandLineRunner commandLineRunner(DepartementRepository departementRepository) {
//        return args -> {
//
//            List<Departement> departementList = new ArrayList<>();
//            departementList.add(new Departement(1,"Mécanique",LocalDate.parse("1992-05-25"),new ArrayList<Enseignant>(),new ArrayList<Groupe>(), new ArrayList<Etudiant>()));
//
//            departementRepository.save(departementList);
//
//        };
//    }
//}
