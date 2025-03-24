package com.kriNad.backend.repositories;

import com.kriNad.backend.model.property.ImageProperty;
import com.kriNad.backend.model.property.ImagePropertyRent;
import com.kriNad.backend.model.property.PropertyRent;
import com.kriNad.backend.model.property.PropertySale;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ImagePropertyRentRepositories extends JpaRepository<ImagePropertyRent, Long> {

    @Query("select im.imageLink from ImagePropertyRent im where im.propertyRent.idProperty=?1")
    public List<String> getImagePropertyRentByPropertyRentId(Long propertyRentId);






}
