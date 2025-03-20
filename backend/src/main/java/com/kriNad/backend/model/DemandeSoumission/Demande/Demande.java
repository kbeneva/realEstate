package com.kriNad.backend.model.DemandeSoumission.Demande;


import jakarta.persistence.*;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.CreationTimestamp;

import java.util.Date;


@MappedSuperclass
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




}
