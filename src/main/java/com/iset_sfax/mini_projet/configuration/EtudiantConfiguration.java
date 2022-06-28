//package com.iset_sfax.mini_projet.configuration;
//
//import com.iset_sfax.mini_projet.entities.Assiduite;
//import com.iset_sfax.mini_projet.entities.Departement;
//import com.iset_sfax.mini_projet.entities.Etudiant;
//import com.iset_sfax.mini_projet.entities.Groupe;
//import com.iset_sfax.mini_projet.repositories.DepartementRepository;
//import com.iset_sfax.mini_projet.repositories.EtudiantRepository;
//import com.iset_sfax.mini_projet.repositories.GroupeRepository;
//import org.springframework.boot.CommandLineRunner;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//
//import java.time.LocalDate;
//import java.util.ArrayList;
//import java.util.HashSet;
//import java.util.List;
//
//@Configuration
//public class EtudiantConfiguration {
//
//    @Bean
//    CommandLineRunner commandLineRunner(EtudiantRepository etudiantRepository, DepartementRepository departementRepository, GroupeRepository groupeRepository) {
//
//        return args -> {
//            List<Etudiant> etudiantList = new ArrayList<>();
//            etudiantList.add(
//                    new Etudiant(0,
//                    "MOUNES",
//                    "Ines",
//                    LocalDate.parse("1992-05-25"),
//                    "/path/to/photo",
//                    "Fares@zoghlami.com",
//                    "1",
//                    LocalDate.parse("2022-09-15"),
//                    2022,
//                    new HashSet<Assiduite>(),
//                    departementRepository.findDepartementByIdDep(1),
//                    groupeRepository.findGroupeByIdGroupe(1)));
//                    new Etudiant(0,
//                            "BENABDALLAH",
//                            "Mariem",
//                            LocalDate.parse("1992-05-25"),
//                            "/path/to/photo",
//                            "Fares@zoghlami.com",
//                            "1",
//                            LocalDate.parse("2022-09-15"),
//                            2022,
//                            new HashSet<Assiduite>(),
//                            departementRepository.findDepartementByIdDep(1),
//                            groupeRepository.findGroupeByIdGroupe(1));
//            etudiantList.add(new Etudiant(0,
//                            "GHAZALA",
//                            "Feriel",
//                            LocalDate.parse("1992-05-25"),
//                            "/path/to/photo",
//                            "Fares@zoghlami.com",
//                            "1",
//                            LocalDate.parse("2022-09-15"),
//                            2022,
//                            new HashSet<Assiduite>(),
//
//                            departementRepository.findDepartementByIdDep(1),
//                            groupeRepository.findGroupeByIdGroupe(1)));
//            etudiantList.add(new Etudiant(0,
//                            "BARHOUMI",
//                            "Amal",
//                            LocalDate.parse("1992-05-25"),
//                            "/path/to/photo",
//                            "Fares@zoghlami.com",
//                            "1",
//                            LocalDate.parse("2022-09-15"),
//                            2022,
//                            new HashSet<Assiduite>(),
//
//                            departementRepository.findDepartementByIdDep(1),
//                            groupeRepository.findGroupeByIdGroupe(1)));
//            etudiantList.add(new Etudiant(0,
//                            "HASNI",
//                            "Maryem",
//                            LocalDate.parse("1992-05-25"),
//                            "/path/to/photo",
//                            "Fares@zoghlami.com",
//                            "1",
//                            LocalDate.parse("2022-09-15"),
//                            2022,
//                            new HashSet<Assiduite>(),
//
//                            departementRepository.findDepartementByIdDep(1),
//                            groupeRepository.findGroupeByIdGroupe(1)));
//            etudiantList.add(new Etudiant(0,
//                            "FRIGUI",
//                            "Khalil",
//                            LocalDate.parse("1992-05-25"),
//                            "/path/to/photo",
//                            "Fares@zoghlami.com",
//                            "1",
//                            LocalDate.parse("2022-09-15"),
//                            2022,
//                            new HashSet<Assiduite>(),
//
//                            departementRepository.findDepartementByIdDep(1),
//                            groupeRepository.findGroupeByIdGroupe(1)));
//            etudiantList.add(new Etudiant(0,
//                            "BEN YOUNES",
//                            "Yasmine",
//                            LocalDate.parse("1992-05-25"),
//                            "/path/to/photo",
//                            "Fares@zoghlami.com",
//                            "1",
//                            LocalDate.parse("2022-09-15"),
//                            2022,
//                            new HashSet<Assiduite>(),
//
//                            departementRepository.findDepartementByIdDep(1),
//                            groupeRepository.findGroupeByIdGroupe(1)));
//            etudiantList.add(new Etudiant(0,
//                            "DARDOURI",
//                            "Oumaima",
//                            LocalDate.parse("1992-05-25"),
//                            "/path/to/photo",
//                            "Fares@zoghlami.com",
//                            "1",
//                            LocalDate.parse("2022-09-15"),
//                            2022,
//                            new HashSet<Assiduite>(),
//
//                            departementRepository.findDepartementByIdDep(1),
//                            groupeRepository.findGroupeByIdGroupe(1)));
//            etudiantList.add(new Etudiant(0,
//                            "HAJJI",
//                            "Zahra",
//                            LocalDate.parse("1992-05-25"),
//                            "/path/to/photo",
//                            "Fares@zoghlami.com",
//                            "1",
//                            LocalDate.parse("2022-09-15"),
//                            2022,
//                            new HashSet<Assiduite>(),
//
//                            departementRepository.findDepartementByIdDep(1),
//                            groupeRepository.findGroupeByIdGroupe(1)));
//            etudiantList.add(new Etudiant(0,
//                            "FODHA",
//                            "Sinda",
//                            LocalDate.parse("1992-05-25"),
//                            "/path/to/photo",
//                            "Fares@zoghlami.com",
//                            "1",
//                            LocalDate.parse("2022-09-15"),
//                            2022,
//                            new HashSet<Assiduite>(),
//
//                            departementRepository.findDepartementByIdDep(1),
//                            groupeRepository.findGroupeByIdGroupe(1)));
//            etudiantList.add(new Etudiant(0,
//                            "HALIMA",
//                            "Youssef",
//                            LocalDate.parse("1992-05-25"),
//                            "/path/to/photo",
//                            "Fares@zoghlami.com",
//                            "1",
//                            LocalDate.parse("2022-09-15"),
//                            2022,
//                            new HashSet<Assiduite>(),
//
//                            departementRepository.findDepartementByIdDep(1),
//                            groupeRepository.findGroupeByIdGroupe(1)));
//            etudiantList.add(new Etudiant(0,
//                            "BEN KADHI",
//                            "Chaima",
//                            LocalDate.parse("1992-05-25"),
//                            "/path/to/photo",
//                            "Fares@zoghlami.com",
//                            "1",
//                            LocalDate.parse("2022-09-15"),
//                            2022,
//                            new HashSet<Assiduite>(),
//
//                            departementRepository.findDepartementByIdDep(1),
//                            groupeRepository.findGroupeByIdGroupe(1)));
//            etudiantList.add(new Etudiant(0,
//                            "ZOGHLAMI",
//                            "Fares",
//                            LocalDate.parse("1992-05-25"),
//                            "/path/to/photo",
//                            "Fares@zoghlami.com",
//                            "1",
//                            LocalDate.parse("2022-09-15"),
//                            2022,
//                            new HashSet<Assiduite>(),
//
//                            departementRepository.findDepartementByIdDep(1),
//                            groupeRepository.findGroupeByIdGroupe(1)));
//            etudiantList.add(new Etudiant(0,
//                    "OKOCHA",
//                    "Jay-Jay",
//                    LocalDate.parse("1992-05-25"),
//                    "/path/to/photo",
//                    "Fares@zoghlami.com",
//                    "1",
//                    LocalDate.parse("2022-09-15"),
//                    2022,
//                    new HashSet<Assiduite>(),
//
//                    departementRepository.findDepartementByIdDep(1),
//                    groupeRepository.findGroupeByIdGroupe(2)));
//
//
//
//
//
//            etudiantRepository.save(etudiantList);
//
//
//        };
//    }
//}
//
