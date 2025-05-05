package com.kriNad.backend.model.DemandeSoumission.Demande;


import com.fasterxml.jackson.annotation.JsonFormat;
import com.kriNad.backend.model.personne.Agent;
import com.kriNad.backend.model.personne.Customer;
import jakarta.persistence.*;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.CreationTimestamp;

import java.util.Date;


@MappedSuperclass

public class Request {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long IdDemande;
    private String typeDemande;
    private String description;

    @ColumnDefault("'pending'")
    private String statusDemande;

    @CreationTimestamp
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
    private Date creationDate;


    @ManyToOne
    private Agent agent;

    @ManyToOne
    private Customer customer;


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



    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Agent getAgent() {
        return agent;
    }

    public void setAgent(Agent agent) {
        this.agent = agent;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }
}
