package com.kriNad.backend.service;


import com.kriNad.backend.model.property.PropertyRent;
import com.kriNad.backend.repositories.PropertyRentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Service
public class PropertyRentService {



    private final PropertyRentRepository propertyRentRepository;

    public PropertyRentService(PropertyRentRepository propertyRentRepository) {
        this.propertyRentRepository = propertyRentRepository;
    }

    public List<PropertyRent> getAll(){
        return propertyRentRepository.findAll();
    }


    /// Filtres //////////////////////////////////////////////////////////////////////

    public List<PropertyRent> findByFilters(String categorie, Long nb, String typeProperty) {
        return propertyRentRepository.findPropertyFilters(categorie,nb, typeProperty);
    };


}
