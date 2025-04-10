package com.kriNad.backend.service;


import com.kriNad.backend.model.property.ImagePropertyRent;
import com.kriNad.backend.repositories.ImagePropertyRentRepositories;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@Service
public class ImagePropertyRentService {


    private final ImagePropertyRentRepositories imagePropertyRentRepositories;

    public ImagePropertyRentService(ImagePropertyRentRepositories imagePropertyRentRepositories) {
        this.imagePropertyRentRepositories = imagePropertyRentRepositories;
    }




    public List<ImagePropertyRent> getAll(){
        return imagePropertyRentRepositories.findAll();
    }


    public List<String> getAllImagesByPropertyId(@RequestParam Long propertyIdProperty){
        return imagePropertyRentRepositories.getImagePropertyRentByPropertyRentId(propertyIdProperty);
    }



}
