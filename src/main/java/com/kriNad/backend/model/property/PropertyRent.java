package com.kriNad.backend.model.property;
import com.kriNad.backend.model.Agent;
import com.kriNad.backend.model.Customer;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;

@Entity
public class PropertyRent extends Property {

    private boolean rent;
    private int maxOccupant;

    public PropertyRent() {
        this.setTypeProperty("À louer");
    }

    public boolean isRent() {
        return rent;
    }

    public void setRent(boolean rent) {
        this.rent = rent;
    }

    public int getMaxOccupant() {
        return maxOccupant;
    }

    public void setMaxOccupant(int maxOccupant) {
        this.maxOccupant = maxOccupant;
    }

    @ManyToOne
    private Agent agent;

    @ManyToOne
    private Customer customer;

    @ManyToOne
    private Location locataire;


}
