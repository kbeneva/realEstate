package com.kriNad.backend.model.DemandeSoumission;


import com.kriNad.backend.model.property.PropertyRent;
import com.kriNad.backend.model.property.PropertySale;
import jakarta.persistence.*;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.CreationTimestamp;

import java.util.Date;

@Entity
public class Soumission {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idSoumission;

    private String typeSoumission;

    @ColumnDefault("'en attente'")
    private String statusDemande;

    @CreationTimestamp
    private Date creationDate;


    public Long getIdSoumission() {
        return idSoumission;
    }

    public void setIdSoumission(Long idSoumission) {
        this.idSoumission = idSoumission;
    }

    public String getTypeSoumission() {
        return typeSoumission;
    }

    public void setTypeSoumission(String typeSoumission) {
        this.typeSoumission = typeSoumission;
    }

    public String getStatusDemande() {
        return statusDemande;
    }

    public void setStatusDemande(String statusDemande) {
        this.statusDemande = statusDemande;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    public PropertySale getPropertySale() {
        return propertySale;
    }

    public void setPropertySale(PropertySale propertySale) {
        this.propertySale = propertySale;
    }

    public PropertyRent getPropertyRent() {
        return propertyRent;
    }

    public void setPropertyRent(PropertyRent propertyRent) {
        this.propertyRent = propertyRent;
    }

    @OneToOne
    private PropertySale propertySale;

    @OneToOne
    private PropertyRent propertyRent;
}
