package com.kriNad.backend.repositories;

import com.kriNad.backend.model.property.ImagePropertyRent;
import com.kriNad.backend.model.property.ImagePropertySale;
import com.kriNad.backend.model.property.PropertySale;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ImagePropertySaleRepositories extends JpaRepository<ImagePropertySale, Long> {




}
