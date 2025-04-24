package com.kriNad.backend.repositories;

import com.kriNad.backend.model.DemandeSoumission.Demande.RequestRent;
import org.springframework.data.jpa.repository.JpaRepository;


public interface RequestRentRepository extends JpaRepository<RequestRent, Long> {
}
