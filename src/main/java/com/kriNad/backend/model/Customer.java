package com.kriNad.backend.model;


import com.kriNad.backend.model.property.Occupant;
import jakarta.persistence.*;

@Entity
public class Customer extends User {

    public Customer() {
        setCustomerAcces(true);
    }

    @ManyToOne
    private Occupant locataire;
}
