package com.kriNad.backend.model;


import com.kriNad.backend.model.property.Location;
import jakarta.persistence.*;

@Entity
public class Agent extends User{

    @ManyToOne
    private Location locataire;
}
