package com.kriNad.backend.model;


import com.kriNad.backend.model.property.Location;
import jakarta.persistence.*;

@Entity
public class Customer extends User {

    public Customer(Location locataire) {
        this.setCustomerAcces(true);
    }

    @ManyToOne
    private Location locataire;
}
