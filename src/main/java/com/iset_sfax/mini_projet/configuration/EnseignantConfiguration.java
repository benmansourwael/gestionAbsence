//package com.iset_sfax.mini_projet.configuration;
//import com.iset_sfax.mini_projet.entities.Departement;
//import com.iset_sfax.mini_projet.entities.Enseignant;
//import com.iset_sfax.mini_projet.repositories.EnseignantRepository;
//import org.springframework.boot.CommandLineRunner;
//import org.springframework.context.annotation.Bean;
//
//import java.time.LocalDate;
//import java.util.ArrayList;
//
//public class EnseignantConfiguration {
//
//    @Bean
//    CommandLineRunner commandLineRunner(EnseignantRepository repository){
//
//        return args ->{
//        repository.save(new Enseignant("wael", "ben mansour", LocalDate.now(), "/", "benmansourwael@live.fr", LocalDate.now(), "Maitre assistant" , new ArrayList<>(), new Departement()));
//
//        };
//    }
//}
