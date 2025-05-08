package com.kriNad.backend.model.personne;

import com.kriNad.backend.model.property.Occupant;
import jakarta.persistence.*;

@Entity
public class Customer extends Personne {

    @ManyToOne
    private Occupant occupant;


    public void setOccupant(Occupant occupant) {
        this.occupant = occupant;
    }
}
