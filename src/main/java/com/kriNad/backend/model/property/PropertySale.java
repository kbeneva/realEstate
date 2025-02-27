package com.kriNad.backend.model.property;
import com.kriNad.backend.model.Agent;
import com.kriNad.backend.model.Customer;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;


@Entity
public class PropertySale extends Property {

    private Boolean sold;

    public PropertySale() {
        this.setTypeProperty("À vendre");
    }


    @ManyToOne
    private Agent agent;

    @ManyToOne
    private Customer customer;


}
