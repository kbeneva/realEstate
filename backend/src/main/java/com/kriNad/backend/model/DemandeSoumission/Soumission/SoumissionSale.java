package com.kriNad.backend.model.DemandeSoumission.Soumission;

import com.kriNad.backend.model.property.PropertySale;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToOne;


@Entity
public class SoumissionSale extends Soumission{



    @OneToOne
    private PropertySale propertySale;

    public PropertySale getPropertySale() {
        return propertySale;
    }

    public void setPropertySale(PropertySale propertySale) {
        this.propertySale = propertySale;
    }
}
