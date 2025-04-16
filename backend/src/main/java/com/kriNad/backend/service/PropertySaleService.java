package com.kriNad.backend.service;


import com.kriNad.backend.model.property.PropertyRent;
import com.kriNad.backend.model.property.PropertySale;
import com.kriNad.backend.repositories.PropertySaleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@Service
public class PropertySaleService {


    private final PropertySaleRepository propertySaleRepository;

    public PropertySaleService(PropertySaleRepository propertySaleRepository) {
        this.propertySaleRepository = propertySaleRepository;
    }


    public List<PropertySale> getAll() {
        return propertySaleRepository.findAll();
    }

    public PropertySale getById(Long id) {
        return propertySaleRepository.findPropertySaleById(id);
    }


    // filtres ////////////////////////////////////////////////////////////

    public List<PropertySale> findByFilters(String categorie, Long minPrice, Long maxPrice, Long nbRooms, Long nbBathrooms, Long nbParking, Long nbGarages, Long minArea, Long maxArea, Long minYear, Long maxYear, String city) {

        return propertySaleRepository.findPropertyFilters(categorie, minPrice, maxPrice, nbRooms, nbBathrooms, nbParking, nbGarages, minArea, maxArea, minYear, maxYear, city);

    };







}
