package com.kriNad.backend.model.property;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.kriNad.backend.model.personne.Agent;
import com.kriNad.backend.model.personne.Customer;
import jakarta.persistence.*;
import java.util.List;

@Entity
public class PropertySale extends Property {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idProperty;

    private Boolean sold;

    @ManyToOne
    @JsonIgnore
    private Customer customer;

    @ManyToOne
    @JsonIgnore
    private Agent agent;

    @OneToMany(mappedBy = "propertySale", cascade = CascadeType.ALL)
    private List<ImagePropertySale> images;

    public Long getIdProperty() {
        return idProperty;
    }

    public void setIdProperty(Long idProperty) {
        this.idProperty = idProperty;
    }

    public Boolean getSold() {
        return sold;
    }

    public void setSold(Boolean sold) {
        this.sold = sold;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Agent getAgent() {
        return agent;
    }

    public void setAgent(Agent agent) {
        this.agent = agent;
    }

    public List<ImagePropertySale> getImages() {
        return images;
    }

    public void setImages(List<ImagePropertySale> images) {
        this.images = images;
    }
}
