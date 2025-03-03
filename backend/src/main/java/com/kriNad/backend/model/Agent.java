package com.kriNad.backend.model;


import com.kriNad.backend.model.property.Occupant;
import jakarta.persistence.*;

@Entity
public class Agent extends Personne {


    public Agent() {
        setAgentAcces(true);
    }

    @ManyToOne
    private Occupant locataire;
}
