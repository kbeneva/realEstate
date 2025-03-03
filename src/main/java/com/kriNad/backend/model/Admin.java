package com.kriNad.backend.model;


import jakarta.persistence.Entity;

@Entity
public class Admin extends Personne {


    public Admin() {
        setAdminAcces(true);
    }


}
