package com.kriNad.backend.model.DemandeSoumission.Demande;

import com.kriNad.backend.model.property.PropertySale;
import jakarta.persistence.*;

@Entity

public class RequestSale extends Request {


    @ManyToOne
    private PropertySale propertySale;

    public PropertySale getPropertySale() {
        return propertySale;
    }

    public void setPropertySale(PropertySale propertySale) {
        this.propertySale = propertySale;
    }
}
