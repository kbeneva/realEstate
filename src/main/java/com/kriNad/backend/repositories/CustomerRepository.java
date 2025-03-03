package com.kriNad.backend.repositories;

import com.kriNad.backend.model.Customer;
import com.kriNad.backend.model.property.PropertySale;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer, Long> {




}
