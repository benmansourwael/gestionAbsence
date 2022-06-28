//package com.javainuse.swaggertest.configuration;
//
//import com.javainuse.swaggertest.entities.Matiere;
//import com.javainuse.swaggertest.entities.SeanceCours;
//import com.javainuse.swaggertest.repositories.MatiereRepository;
//import org.springframework.boot.CommandLineRunner;
//import org.springframework.context.annotation.Bean;
//
//import java.util.ArrayList;
//
//public class MatiereConfiguration {
//    @Bean
//    CommandLineRunner commandLineRunner(MatiereRepository repository){
//        return args ->{
//            repository.save(new Matiere("nomMat",  1.5F,  12.5F,  10.0F, new ArrayList<SeanceCours>()));
//
//        };
//    }
//}
