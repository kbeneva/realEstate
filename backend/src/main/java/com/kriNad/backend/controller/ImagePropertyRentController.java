package com.kriNad.backend.controller;


import com.kriNad.backend.model.property.ImagePropertyRent;
import com.kriNad.backend.model.property.PropertyRent;
import com.kriNad.backend.repositories.ImagePropertyRentRepositories;
import com.kriNad.backend.repositories.ImagePropertySaleRepositories;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/ImagePropertyRent")
@CrossOrigin
public class ImagePropertyRentController {


    @Autowired
    ImagePropertyRentRepositories imagePropertyRentRepositories;

    @GetMapping("/getAllImageRent")
    public List<ImagePropertyRent> getAll(){
        return imagePropertyRentRepositories.findAll();
    }


    @GetMapping("/getAllImagesByPropertyId")
    public List<String> getAllImagesByPropertyId(@RequestParam Long propertyIdProperty){
        return imagePropertyRentRepositories.getImagePropertyRentByPropertyRentId(propertyIdProperty);
    }



}
