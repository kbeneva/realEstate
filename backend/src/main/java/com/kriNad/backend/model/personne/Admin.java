package com.kriNad.backend.model.personne;

import jakarta.persistence.Entity;

@Entity
public class Admin extends Personne {
    private Boolean adminAcces = true;

    @Override
    public Boolean getAdminAcces() {
        return adminAcces;
    }

    @Override
    public void setAdminAcces(Boolean adminAcces) {
        this.adminAcces = adminAcces;
    }
}
