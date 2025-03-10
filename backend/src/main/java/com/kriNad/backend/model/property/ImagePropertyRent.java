package com.kriNad.backend.model.property;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;


@Entity
public class ImagePropertyRent extends ImageProperty{


    public PropertyRent getPropertyRent() {
        return propertyRent;
    }

    public void setPropertyRent(PropertyRent propertyRent) {
        this.propertyRent = propertyRent;
    }

    @ManyToOne
    private PropertyRent propertyRent;
}
