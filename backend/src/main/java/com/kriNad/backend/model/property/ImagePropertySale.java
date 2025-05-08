package com.kriNad.backend.model.property;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;

@Entity
public class ImagePropertySale extends ImageProperty{

    @ManyToOne
    private PropertySale propertySale;


    public void setPropertySale(PropertySale propertySale) {
        this.propertySale = propertySale;
    }
}
