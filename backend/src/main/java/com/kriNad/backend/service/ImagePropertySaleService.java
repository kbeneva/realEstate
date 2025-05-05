package com.kriNad.backend.service;

import com.kriNad.backend.model.property.ImagePropertySale;
import com.kriNad.backend.repositories.ImagePropertySaleRepositories;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@Service
public class ImagePropertySaleService {



    private final ImagePropertySaleRepositories imagePropertySaleRepositories;

    public ImagePropertySaleService(ImagePropertySaleRepositories imagePropertySaleRepositories) {
        this.imagePropertySaleRepositories = imagePropertySaleRepositories;
    }


    public List<ImagePropertySale> getAll(){
        return imagePropertySaleRepositories.findAll();
    }


    public List<String> getAllImagesByPropertyId(Long propertyIdProperty){
        return imagePropertySaleRepositories.getImagePropertySaleByPropertySaleId(propertyIdProperty);
    }

}

