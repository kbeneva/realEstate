package com.kriNad.backend.controller;
import com.kriNad.backend.exception.PropertySaleNotFoundException;
import com.kriNad.backend.model.property.PropertySale;
import com.kriNad.backend.service.PropertySaleService;
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
    PropertySaleService propertySaleService;


    @GetMapping("/getAllProperty")
    public List<PropertySale> getAll() {
        return propertySaleService.getAll();
    }

    @GetMapping("/{id}")
    public PropertySale getById(@PathVariable Long id) {
        return propertySaleService.getById(id).orElseThrow(() -> new PropertySaleNotFoundException(id));
    }



    @GetMapping("/filtre")
    public List <PropertySale> findPropertyFilters(
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
            @RequestParam(required = false)String city) {
        return propertySaleService.findByFilters(categorie, minPrice, maxPrice, nbRooms, nbBathrooms, nbParking, nbGarages, minArea, maxArea, minYear, maxYear, city);


    }
}
