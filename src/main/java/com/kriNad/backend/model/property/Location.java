package com.kriNad.backend.model.property;


import jakarta.persistence.Entity;
import jakarta.persistence.Id;



// plusieurs propriétés à louer pour plusieurs locataire
@Entity
public class Location {


    @Id
    private Long id;

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }
}
