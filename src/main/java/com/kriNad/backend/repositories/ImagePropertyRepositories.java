package com.kriNad.backend.repositories;

import com.kriNad.backend.model.Customer;
import com.kriNad.backend.model.property.ImageProperty;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ImagePropertyRepositories extends JpaRepository<ImageProperty, Long> {
}
