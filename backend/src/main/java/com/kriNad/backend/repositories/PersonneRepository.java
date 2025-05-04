package com.kriNad.backend.repositories;

import com.kriNad.backend.model.personne.Personne;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonneRepository extends JpaRepository<Personne, Long> {
}
