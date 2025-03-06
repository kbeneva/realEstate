package com.kriNad.backend.model;


import com.kriNad.backend.model.property.Occupant;
import jakarta.persistence.*;

@Entity
public class Customer extends Personne {


    @ManyToOne
    private Occupant locataire;
}
