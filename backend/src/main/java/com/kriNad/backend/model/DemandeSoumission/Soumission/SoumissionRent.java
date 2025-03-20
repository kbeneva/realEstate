package com.kriNad.backend.model.DemandeSoumission.Soumission;

import com.kriNad.backend.model.property.PropertyRent;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToOne;


@Entity
public class SoumissionRent extends Soumission{


    @OneToOne
    private PropertyRent propertyRent;

    public PropertyRent getPropertyRent() {
        return propertyRent;
    }

    public void setPropertyRent(PropertyRent propertyRent) {
        this.propertyRent = propertyRent;
    }
}
