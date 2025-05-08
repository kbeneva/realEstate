package com.kriNad.backend.controller;

import com.kriNad.backend.model.personne.Personne;
import com.kriNad.backend.repositories.PersonneRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/Auth")
@CrossOrigin(origins = "*")
public class PersonneController {

    @Autowired
    private PersonneRepository personneRepository;

    @PutMapping("/personne/{id}")
    public Personne updatePersonne(@RequestBody Personne newOne, @PathVariable Long id) {
        return personneRepository.findById(id)
                .map(personne -> {
                    personne.setFname(newOne.getFname());
                    personne.setLname(newOne.getLname());
                    personne.setEmail(newOne.getEmail());
                    personne.setPhone(newOne.getPhone());
                    return personneRepository.save(personne);
                })
                .orElseThrow(() -> new RuntimeException("Person not found with id " + id));
    }
}
