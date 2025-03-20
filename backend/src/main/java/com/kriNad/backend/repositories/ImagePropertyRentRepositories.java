package com.kriNad.backend.repositories;

import com.kriNad.backend.model.property.ImageProperty;
import com.kriNad.backend.model.property.ImagePropertyRent;
import com.kriNad.backend.model.property.PropertyRent;
import com.kriNad.backend.model.property.PropertySale;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ImagePropertyRentRepositories extends JpaRepository<ImagePropertyRent, Long> {

    List<ImagePropertyRent> getImagePropertyRentByPropertyRent_IdProperty(Long propertyRentIdProperty);






}
