package com.kriNad.backend.repositories;

import com.kriNad.backend.model.property.ImagePropertyRent;
import com.kriNad.backend.model.property.ImagePropertySale;
import com.kriNad.backend.model.property.PropertySale;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ImagePropertySaleRepositories extends JpaRepository<ImagePropertySale, Long> {

     @Query("select im.propertySale.idProperty,  im.imageLink from ImagePropertySale im where im.propertySale.idProperty=?1")
    public List<String> getImagePropertySaleByPropertySaleId(Long propertySaleId);


}
