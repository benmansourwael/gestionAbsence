//package com.iset_sfax.mini_projet.configuration;
//
//import com.iset_sfax.mini_projet.entities.Assiduite;
//import com.iset_sfax.mini_projet.entities.Departement;
//import com.iset_sfax.mini_projet.entities.Etudiant;
//import com.iset_sfax.mini_projet.entities.Groupe;
//import com.iset_sfax.mini_projet.repositories.DepartementRepository;
//import com.iset_sfax.mini_projet.repositories.EtudiantRepository;
//import com.iset_sfax.mini_projet.repositories.GroupeRepository;
//import org.joda.time.DateTime;
//import org.joda.time.DateTimeZone;
//import org.joda.time.format.DateTimeFormat;
//import org.joda.time.format.DateTimeFormatter;
//import org.json.JSONArray;
//import org.json.JSONObject;
//import org.springframework.boot.web.client.RestTemplateBuilder;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.web.client.RestTemplate;
//
//import java.time.LocalDate;
//import java.util.ArrayList;
//import java.util.HashSet;
//import java.util.List;
//import java.util.Set;
//
//@Configuration
//public class EtudiantConfigurationFakeData {
//    private final RestTemplate restTemplate;
//
//    public EtudiantConfigurationFakeData(RestTemplateBuilder restTemplateBuilder) {
//        this.restTemplate = restTemplateBuilder.build();
//
//    }
//
//
//    public String getUser() {
//        String url = "https://randomuser.me/api/";
//        return this.restTemplate.getForObject(url, String.class);
//    }
//
//    @Bean
//    public List<Etudiant> addStudents(EtudiantRepository etudiantRepository, DepartementRepository departementRepository, GroupeRepository groupeRepository) {
//        List<Etudiant> etudiantList = new ArrayList<>();
//        for (int w = 0; w < 25; w++) {
//            String url = "https://randomuser.me/api/";
//            JSONObject jsonObject = new JSONObject(this.restTemplate.getForObject(url, String.class));
//
//            JSONArray results = jsonObject.getJSONArray("results");
//            Etudiant etudiant = null;
//            String pattern = "yyyy-MM-dd'T'HH:mm:ssZ";
//            DateTimeFormatter dtf = DateTimeFormat.forPattern(pattern);
//            DateUtils dateUtils = new DateUtils();
//
//
//            for (int i = 0; i < results.length(); i++) {
//
//                String nom = results.getJSONObject(i).getJSONObject("name").getString("last");
//                String prenom = results.getJSONObject(i).getJSONObject("name").getString("first");
//                LocalDate ddn = dateUtils.toLocalDate(dtf.parseDateTime(results.getJSONObject(i).getJSONObject("dob").getString("date").substring(0, results.getJSONObject(i).getJSONObject("dob").getString("date").indexOf('.')) + "Z"));
//                String photo = results.getJSONObject(i).getJSONObject("picture").getString("thumbnail");
//                String email = results.getJSONObject(i).getString("email");
//                String numInscription = "10";
//                LocalDate ddi = LocalDate.parse("2022-09-15");
//                int au = 2022;
//                Set<Assiduite> assiduiteSet = new HashSet<Assiduite>();
//                Departement departement = departementRepository.findDepartementByIdDep(1);
//                Groupe groupe = groupeRepository.findGroupeByIdGroupe(1);
//                etudiant = new Etudiant();
//                etudiant.setNumEtd(0);
//                etudiant.setNomEtd(nom);
//                etudiant.setPrenomEtd(prenom);
//                etudiant.setDateNaissanceEtd(ddn);
//                etudiant.setPhotoEtd(photo);
//                etudiant.setAdresseMailEtd(email);
//                etudiant.setNumInscription(numInscription);
//                etudiant.setDateInscription(ddi);
//                etudiant.setAu(au);
//                etudiant.setAssiduites(assiduiteSet);
//                etudiant.setDepartement(departement);
//                etudiant.setGroupe(groupe);
//            }
//            etudiantList.add(etudiant);
//
//
//        }
//        etudiantRepository.save(etudiantList);
//        return etudiantList;
//    }
//
////    @Bean
////    CommandLineRunner commandLineRunner(RestTemplateBuilder restTemplate, EtudiantRepository etudiantRepository, DepartementRepository departementRepository, GroupeRepository groupeRepository) {
////
////        return args -> {
////            List<Etudiant> etudiantList = new ArrayList<>();
////            EtudiantConfiguration etudiantConfiguration = new EtudiantConfiguration(restTemplate);
////            Etudiant etudiant = etudiantConfiguration.addStudents(etudiantRepository, departementRepository, groupeRepository);
////            etudiantList.add(etudiant);
////
////
////            //etudiantRepository.save(etudiantList);
////
////
////        };
////    }
////}
//
//    class DateUtils {
//
//        /**
//         * Convert {@link java.time.LocalDate} to {@link org.joda.time.DateTime}
//         */
//        public DateTime toDateTime(LocalDate localDate) {
//            return new DateTime(DateTimeZone.UTC).withDate(
//                    localDate.getYear(), localDate.getMonthValue(), localDate.getDayOfMonth()
//            ).withTime(0, 0, 0, 0);
//        }
//
//        /**
//         * Convert {@link org.joda.time.DateTime} to {@link java.time.LocalDate}
//         */
//        public LocalDate toLocalDate(DateTime dateTime) {
//            DateTime dateTimeUtc = dateTime.withZone(DateTimeZone.UTC);
//            return LocalDate.of(dateTimeUtc.getYear(), dateTimeUtc.getMonthOfYear(), dateTimeUtc.getDayOfMonth());
//        }
//    }
//}
//
