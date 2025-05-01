package com.kriNad.backend.service;


import com.kriNad.backend.model.property.PropertyRent;
import com.kriNad.backend.repositories.PropertyRentRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PropertyRentService {



    private final PropertyRentRepository propertyRentRepository;

    public PropertyRentService(PropertyRentRepository propertyRentRepository) {
        this.propertyRentRepository = propertyRentRepository;
    }

    ////////////////////////

    public List<PropertyRent> getAll(){
        return propertyRentRepository.findAll();
    }

    public Optional<PropertyRent> getById(Long id){
        return propertyRentRepository.findById(id);
    }


    /// Filtres //////////////////////////////////////////////////////////////////////

    public List<PropertyRent> findByFilters(String categorie, Long minPrice, Long maxPrice, Long nbRooms, Long nbBathrooms, Long nbParking, Long nbGarages, Long minArea, Long maxArea, Long minYear,Long maxYear, String city) {

        return propertyRentRepository.findPropertyFilters(categorie, minPrice, maxPrice, nbRooms, nbBathrooms, nbParking, nbGarages, minArea, maxArea, minYear, maxYear, city);

    };

    public List<PropertyRent> getPropertyByCustomer(long idUser) {
        return propertyRentRepository.getPropertyByCustomer(idUser);
    }

    public PropertyRent save(PropertyRent rent) {
        return propertyRentRepository.save(rent);
    }



}
