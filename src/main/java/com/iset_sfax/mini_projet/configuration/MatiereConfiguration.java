//package com.iset_sfax.mini_projet.configuration;
//
//
//import com.iset_sfax.mini_projet.entities.Matiere;
//import com.iset_sfax.mini_projet.repositories.MatiereRepository;
//import org.springframework.boot.CommandLineRunner;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//
//@Configuration
//public class MatiereConfiguration {
//    @Bean
//    CommandLineRunner commandLineRunner(MatiereRepository repository) {
//        return args -> {
//            repository.save(new Matiere(1, "nomMat", 1.5F, 12.5F, 10.0F));
//
//        };
//    }
//}