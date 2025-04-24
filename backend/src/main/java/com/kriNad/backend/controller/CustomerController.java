package com.kriNad.backend.controller;

import com.kriNad.backend.exception.CustomerNotFoundException;
import com.kriNad.backend.model.personne.Customer;
import com.kriNad.backend.repositories.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "http://localhost:9292")
public class CustomerController {

    @Autowired
    private CustomerRepository customerRepository;

    @GetMapping("/customers")
    public List<Customer> getAllCustomers() {
        return customerRepository.findAll();
    }

    @DeleteMapping("/customer/{id}")
    String deleteCustomer(@PathVariable Long id){
        if(!customerRepository.existsById(id)){
            throw new CustomerNotFoundException(id);
        }
        customerRepository.deleteById(id);
        return  "Customer with id "+id+" has been deleted success.";
    }
}
