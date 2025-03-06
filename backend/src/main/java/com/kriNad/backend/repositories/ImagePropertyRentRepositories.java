package com.kriNad.backend.repositories;

import com.kriNad.backend.model.property.ImageProperty;
import com.kriNad.backend.model.property.ImagePropertyRent;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ImagePropertyRentRepositories extends JpaRepository<ImagePropertyRent, Long> {
}
