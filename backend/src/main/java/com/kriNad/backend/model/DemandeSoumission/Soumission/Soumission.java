package com.kriNad.backend.model.DemandeSoumission.Soumission;


import jakarta.persistence.*;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.CreationTimestamp;

import java.util.Date;


@MappedSuperclass
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




}
