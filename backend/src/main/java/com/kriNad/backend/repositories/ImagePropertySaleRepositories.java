package com.kriNad.backend.repositories;

import com.kriNad.backend.model.property.ImagePropertyRent;
import com.kriNad.backend.model.property.ImagePropertySale;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ImagePropertySaleRepositories extends JpaRepository<ImagePropertySale, Long> {
}
