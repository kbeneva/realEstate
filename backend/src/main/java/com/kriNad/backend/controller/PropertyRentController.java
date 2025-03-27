package com.kriNad.backend.controller;


import com.kriNad.backend.model.property.PropertyRent;
import com.kriNad.backend.model.property.PropertySale;
import com.kriNad.backend.repositories.PropertyRentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/propertyRent")
@CrossOrigin
public class PropertyRentController {

    @Autowired
    PropertyRentRepository propertyRentRepository;


    @GetMapping("/getAllProperty")
    public List<PropertyRent> getAll(){
        return propertyRentRepository.findAll();
    }


}
