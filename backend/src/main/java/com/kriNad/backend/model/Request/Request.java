package com.kriNad.backend.model.Request;

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
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "unique_seq")
    private long idDemande;
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


    public String getStatusDemande() {
        return statusDemande;
    }

    public void setStatusDemande(String statusDemande) {
        this.statusDemande = statusDemande;
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
