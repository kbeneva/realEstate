package com.kriNad.backend.controller;


import com.kriNad.backend.model.property.PropertySale;
import com.kriNad.backend.repositories.PropertySaleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.*;
import java.util.List;


@RestController
@RequestMapping("/propertySale")
@CrossOrigin
public class PropertySaleController {

    @Autowired
    PropertySaleRepository propertySaleRepository;


    @GetMapping("/getAllSaleProperty")
    public List<PropertySale> getAll() {
        return propertySaleRepository.findAll();
    }







}
