package com.kriNad.backend.model.property;
import com.kriNad.backend.model.Agent;
import com.kriNad.backend.model.Customer;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

@Entity
public class PropertyRent extends Property {



    private boolean rent;
    private Long maxOccupant;

    public PropertyRent() {
        this.setTypeProperty("À louer");
    }


    @ManyToOne
    private Agent agent;

    @ManyToOne
    private Customer customer;

    @ManyToOne
    private Occupant location;


}
