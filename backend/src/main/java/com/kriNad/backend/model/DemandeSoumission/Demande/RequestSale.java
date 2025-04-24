package com.kriNad.backend.model.DemandeSoumission.Demande;

import com.kriNad.backend.model.property.PropertySale;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToOne;

@Entity

public class RequestSale extends Request {


    @OneToOne
    private PropertySale propertySale;

    public PropertySale getPropertySale() {
        return propertySale;
    }

    public void setPropertySale(PropertySale propertySale) {
        this.propertySale = propertySale;
    }
}
