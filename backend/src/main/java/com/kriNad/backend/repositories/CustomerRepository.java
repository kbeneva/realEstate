package com.kriNad.backend.repositories;

import com.kriNad.backend.model.personne.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer, Long> {




}
