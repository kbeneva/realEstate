package com.kriNad.backend.model.property;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;


@Entity
public class ImagePropertyRent extends ImageProperty{


    @ManyToOne
    private PropertyRent propertyRent;
}
