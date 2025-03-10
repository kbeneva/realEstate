package com.kriNad.backend.model.property;
import com.kriNad.backend.model.Agent;
import com.kriNad.backend.model.Customer;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.PrePersist;
import org.hibernate.annotations.ColumnDefault;

@Entity
public class PropertyRent extends Property {

    private boolean rent;
    private Long maxOccupants;


    @ColumnDefault("'rent'")
    private String typeProperty;


    public boolean isRent() {
        return rent;
    }

    public void setRent(boolean rent) {
        this.rent = rent;
    }

    public Long getMaxOccupants() {
        return maxOccupants;
    }

    public void setMaxOccupants(Long maxOccupants) {
        this.maxOccupants = maxOccupants;
    }

    public String getTypeProperty() {
        return typeProperty;
    }

    public void setTypeProperty(String typeProperty) {
        this.typeProperty = typeProperty;
    }

    public Agent getAgent() {
        return agent;
    }

    public void setAgent(Agent agent) {
        this.agent = agent;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Occupant getOccupant() {
        return occupant;
    }

    public void setOccupant(Occupant occupant) {
        this.occupant = occupant;
    }

    @ManyToOne
    private Agent agent;

    @ManyToOne
    private Customer customer;

    @ManyToOne
    private Occupant occupant;


}
