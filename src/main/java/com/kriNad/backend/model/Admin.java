package com.kriNad.backend.model;


import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Admin extends User {


    public Admin() {
        setAdminAcces(true);
    }


}
