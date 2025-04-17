package com.kriNad.backend.controller;


import com.kriNad.backend.exception.PropertyRentNotFoundException;
import com.kriNad.backend.model.property.PropertyRent;
import com.kriNad.backend.model.property.PropertySale;
import com.kriNad.backend.repositories.PropertyRentRepository;
import com.kriNad.backend.service.PropertyRentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/propertyRent")
@CrossOrigin
public class PropertyRentController {

    @Autowired
    private PropertyRentService propertyRentService;


    @GetMapping("/getAllProperty")
    public List<PropertyRent> getAll(){
        return propertyRentService.getAll();
    }



    @GetMapping("/{id}")
    public PropertyRent getById(@PathVariable Long id){
        return propertyRentService.getById(id).orElseThrow(() -> new PropertyRentNotFoundException(id));
    }


    @GetMapping("/filtre")
    public List <PropertyRent> findPropertyFilters(
            @RequestParam(required = false) String categorie,
            @RequestParam(required = false)Long minPrice,
            @RequestParam(required = false)Long maxPrice,
            @RequestParam(required = false)Long nbRooms,
            @RequestParam(required = false)Long nbBathrooms,
            @RequestParam(required = false)Long nbParking,
            @RequestParam(required = false)Long nbGarages,
            @RequestParam(required = false)Long minArea,
            @RequestParam(required = false)Long maxArea,
            @RequestParam(required = false)Long minYear,
            @RequestParam(required = false)Long maxYear,
            @RequestParam(required = false)String city){
        return propertyRentService.findByFilters(categorie, minPrice, maxPrice, nbRooms, nbBathrooms, nbParking, nbGarages, minArea, maxArea, minYear, maxYear, city);
    }

}
