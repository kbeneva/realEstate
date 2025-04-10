package com.kriNad.backend.controller;


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
    PropertyRentService PropertyRentService;
    @Autowired
    private PropertyRentService propertyRentService;


    @GetMapping("/getAllProperty")
    public List<PropertyRent> getAll(){
        return propertyRentService.getAll();
    }


    @GetMapping("/filtre")
    public List <PropertyRent> findPropertyFilters(@RequestParam(required = false) String categorie, @RequestParam(required = false) Long nb, @RequestParam(required = false)String typeProperty){
        return propertyRentService.findByFilters(categorie, nb, typeProperty);
    }

}
