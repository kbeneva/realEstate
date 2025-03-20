package com.kriNad.backend.repositories;

import com.kriNad.backend.model.property.PropertyRent;
import com.kriNad.backend.model.property.PropertySale;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface PropertyRentRepository extends JpaRepository<PropertyRent, Long> {



    @Query("select pr.idProperty, ipr.imageLink from PropertyRent pr left join ImagePropertyRent ipr on ipr.propertyRent =  pr")
    public List<String>getPropertyRentAndImages();


}
