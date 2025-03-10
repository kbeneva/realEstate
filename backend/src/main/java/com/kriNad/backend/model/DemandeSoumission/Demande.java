package com.kriNad.backend.model.DemandeSoumission;


import com.kriNad.backend.model.property.PropertyRent;
import com.kriNad.backend.model.property.PropertySale;
import jakarta.persistence.*;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.CreationTimestamp;

import java.util.Date;

@Entity
public class Demande {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long IdDemande;
    private String typeDemande;

    @ColumnDefault("'en attente'")
    private String statusDemande;

    @CreationTimestamp
    private Date creationDate;


    public long getIdDemande() {
        return IdDemande;
    }

    public void setIdDemande(long idDemande) {
        IdDemande = idDemande;
    }

    public String getTypeDemande() {
        return typeDemande;
    }

    public void setTypeDemande(String typeDemande) {
        this.typeDemande = typeDemande;
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
