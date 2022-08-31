//package com.iset_sfax.mini_projet.configuration;
//
//import com.iset_sfax.mini_projet.entities.Groupe;
//import com.iset_sfax.mini_projet.repositories.DepartementRepository;
//import com.iset_sfax.mini_projet.repositories.GroupeRepository;
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
//@AutoConfigureOrder(2)
//public class GroupeConfiguration {
//    @Bean
//    CommandLineRunner commandLineRunner(DepartementRepository departementRepository, GroupeRepository groupeRepository){
//        return args ->{
//            List<Groupe> groupeList = new ArrayList<>();
//            groupeList.add(new Groupe(1,"DSIR", LocalDate.parse("1999-09-15"),2022,departementRepository.findDepartementByIdDep(1)));
//            groupeRepository.save(groupeList);
//
//        };
//    }
//}
