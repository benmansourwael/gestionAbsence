package com.iset_sfax.mini_projet.repositories;
import com.iset_sfax.mini_projet.entities.Assiduite;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AssiduiteRepository extends JpaRepository<Assiduite,Integer> {
     Optional<Assiduite> findAssiduiteByAssiduiteId(int assiduite_id);
}
