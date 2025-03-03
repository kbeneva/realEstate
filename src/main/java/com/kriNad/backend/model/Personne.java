package com.kriNad.backend.model;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;


@MappedSuperclass
public class Personne {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idUser;
    private String fname;
    private String lname;
    private String email;
    private String phone;
    private String password;
    private Boolean agentAcces;
    private Boolean customerAcces;
    private Boolean adminAcces;

    public Long getId() {
        return idUser;
    }

    public void setId(Long id) {
        this.idUser = id;
    }

    public String getFname() {
        return fname;
    }

    public void setFname(String fname) {
        this.fname = fname;
    }

    public String getLname() {
        return lname;
    }

    public void setLname(String lname) {
        this.lname = lname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Boolean getAgentAcces() {
        return agentAcces;
    }

    public void setAgentAcces(Boolean agentAcces) {
        this.agentAcces = agentAcces;
    }

    public Boolean getCustomerAcces() {
        return customerAcces;
    }

    public void setCustomerAcces(Boolean customerAcces) {
        this.customerAcces = customerAcces;
    }

    public Boolean getAdminAcces() {
        return adminAcces;
    }

    public void setAdminAcces(Boolean adminAcces) {
        this.adminAcces = adminAcces;
    }
}
