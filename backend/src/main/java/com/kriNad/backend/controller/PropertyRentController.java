package com.kriNad.backend.controller;

import com.kriNad.backend.DTO.PropertyRentRequest;
import com.kriNad.backend.exception.PropertyRentNotFoundException;
import com.kriNad.backend.model.personne.Customer;
import com.kriNad.backend.model.property.ImagePropertyRent;
import com.kriNad.backend.model.property.PropertyRent;
import com.kriNad.backend.repositories.CustomerRepository;
import com.kriNad.backend.repositories.ImagePropertyRentRepositories;
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

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private ImagePropertyRentRepositories imageRentRepo;



    @Autowired
    private PropertyRentRepository propertyRentRepository;

    @GetMapping("/getAllProperty")
    public List<PropertyRent> getAll() {
        return propertyRentService.getAll();
    }

    @GetMapping("/{id}")
    public PropertyRent getById(@PathVariable Long id) {
        return propertyRentService.getById(id).orElseThrow(() -> new PropertyRentNotFoundException(id));
    }

    @GetMapping("/agent/{id}")
    public List<PropertyRent> getPropertyByAgent(@PathVariable Long id) {
        return propertyRentService.getPropertyByAgent(id);}


    @GetMapping("/filtre")
    public List<PropertyRent> findPropertyFilters(
            @RequestParam(required = false) String categorie,
            @RequestParam(required = false) Long minPrice,
            @RequestParam(required = false) Long maxPrice,
            @RequestParam(required = false) Long nbRooms,
            @RequestParam(required = false) Long nbBathrooms,
            @RequestParam(required = false) Long nbParking,
            @RequestParam(required = false) Long nbGarages,
            @RequestParam(required = false) Long minArea,
            @RequestParam(required = false) Long maxArea,
            @RequestParam(required = false) Long minYear,
            @RequestParam(required = false) Long maxYear,
            @RequestParam(required = false) String city) {
        return propertyRentService.findByFilters(categorie, minPrice, maxPrice, nbRooms, nbBathrooms, nbParking, nbGarages, minArea, maxArea, minYear, maxYear, city);
    }

    @PostMapping
    public PropertyRent createPropertyRent(@RequestBody PropertyRentRequest request) {
        if (request.getCustomerId() == null) {
            throw new RuntimeException("Customer ID is required!");
        }

        Customer customer = customerRepository.findById(request.getCustomerId())
                .orElseThrow(() -> new RuntimeException("Customer not found"));

        PropertyRent property = new PropertyRent();
        property.setDescription(request.getDescription());
        property.setCategorie(request.getCategorie());
        property.setPrice(request.getPrice());
        property.setAddress(request.getAddress());
        property.setNbRooms(request.getNbRooms());
        property.setNbBathrooms(request.getNbBathrooms());
        property.setNbParkingSpace(request.getNbParkingSpace());
        property.setNbGarages(request.getNbGarages());
        property.setArea(request.getArea());
        property.setConstructionYear(request.getConstructionYear());
        property.setCity(request.getCity());
        property.setIsAccepted(false);
        property.setCustomer(customer);
        property.setRent(true);
        property.setMaxOccupants(request.getMaxOccupants());

        PropertyRent saved = propertyRentService.save(property);

        for (String imageLink : request.getImages()) {
            ImagePropertyRent image = new ImagePropertyRent();
            image.setImageLink(imageLink);
            image.setPropertyRent(saved);
            imageRentRepo.save(image);
        }

        return saved;
    }

    @GetMapping("/customer/{customerId}")
    public List<PropertyRent> getPropertyRentsByCustomer(@PathVariable Long customerId) {
        return propertyRentRepository.getPropertyByCustomer(customerId);
    }
}
