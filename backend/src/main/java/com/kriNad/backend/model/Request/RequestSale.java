package com.kriNad.backend.model.Request;

import com.kriNad.backend.model.property.PropertySale;
import jakarta.persistence.*;

@Entity

public class RequestSale extends Request {

    @SequenceGenerator(sequenceName = "sale_id_seq", allocationSize = 1, name="unique_seq")

    @ManyToOne
    private PropertySale propertySale;

    public void setPropertySale(PropertySale propertySale) {
        this.propertySale = propertySale;
    }

    public PropertySale getPropertySale() {
        return propertySale;
    }
}
