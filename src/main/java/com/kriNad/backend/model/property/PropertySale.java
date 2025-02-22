package com.kriNad.backend.model.property;
import com.kriNad.backend.model.Agent;
import com.kriNad.backend.model.Customer;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;


@Entity
public class PropertySale extends Property {

    private boolean sold;

    public PropertySale() {
        this.setTypeProperty("À vendre");
    }



    public boolean isSold() {
        return sold;
    }

    public void setSold(boolean sold) {
        this.sold = sold;
    }


    @ManyToOne
    private Agent agent;

    @ManyToOne
    private Customer customer;


}
