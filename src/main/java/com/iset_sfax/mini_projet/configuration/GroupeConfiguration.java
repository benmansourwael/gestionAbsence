//package com.iset_sfax.mini_projet.configuration;
//
//import com.iset_sfax.mini_projet.entities.Groupe;
//import com.iset_sfax.mini_projet.repositories.DepartementRepository;
//import com.iset_sfax.mini_projet.repositories.GroupeRepository;
//import org.springframework.boot.CommandLineRunner;
//import org.springframework.context.annotation.Bean;
//
//import java.time.LocalDate;
//import java.util.ArrayList;
//import java.util.List;
//
//public class GroupeConfiguration {
//    @Bean
//    CommandLineRunner commandLineRunner(GroupeRepository groupeRepository, DepartementRepository departementRepository){
//        return args ->{
//            List<Groupe> groupeList = new ArrayList<>();
//            groupeList.add(new Groupe(1,"DSIR", LocalDate.parse("1999-09-15"),2022,departementRepository.findDepartementByIdDep(1)));
//            groupeRepository.save(groupeList);
//
//        };
//    }
//}
