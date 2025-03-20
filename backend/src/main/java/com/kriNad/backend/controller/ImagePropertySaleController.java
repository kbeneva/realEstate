package com.kriNad.backend.controller;

import com.kriNad.backend.model.property.ImagePropertyRent;
import com.kriNad.backend.model.property.ImagePropertySale;
import com.kriNad.backend.model.property.PropertyRent;
import com.kriNad.backend.repositories.ImagePropertySaleRepositories;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/ImagePropertySale")
@CrossOrigin

public class ImagePropertySaleController {


    @Autowired
    ImagePropertySaleRepositories imagePropertySaleRepositories;



    @GetMapping("/getAllSaleProperty")
    public List<ImagePropertySale> getAll(){
        return imagePropertySaleRepositories.findAll();
    }

}
