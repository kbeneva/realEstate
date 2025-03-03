package com.kriNad.backend.model.property;
import com.kriNad.backend.model.Agent;
import com.kriNad.backend.model.Customer;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;

@Entity
public class PropertyRent extends Property {



    private boolean rent;
    private Long maxOccupants;

    public PropertyRent() {
        this.setTypeProperty("sale");
    }


    @ManyToOne
    private Agent agent;

    @ManyToOne
    private Customer customer;

    @ManyToOne
    private Occupant location;


}
