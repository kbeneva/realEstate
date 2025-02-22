package com.kriNad.backend.model.property;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;

@MappedSuperclass
public class Property {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idProperty;
    private String description;
    private String typeProperty;
    private String categorie;
    private double price;
    private String address;
    private int nbChambre;
    private int nbSalleBain;
    private int nbstationnement;
    private int nbGarage;
    private double superficie;
    private int anneeConstruction;


    public Long getIdProperty() {
        return idProperty;
    }

    public void setIdProperty(Long idProperty) {
        this.idProperty = idProperty;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getTypeProperty() {
        return typeProperty;
    }

    public void setTypeProperty(String typeProperty) {
        this.typeProperty = typeProperty;
    }

    public String getCategorie() {
        return categorie;
    }

    public void setCategorie(String categorie) {
        this.categorie = categorie;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getNbChambre() {
        return nbChambre;
    }

    public void setNbChambre(int nbChambre) {
        this.nbChambre = nbChambre;
    }

    public int getNbSalleBain() {
        return nbSalleBain;
    }

    public void setNbSalleBain(int nbSalleBain) {
        this.nbSalleBain = nbSalleBain;
    }

    public int getNbstationnement() {
        return nbstationnement;
    }

    public void setNbstationnement(int nbstationnement) {
        this.nbstationnement = nbstationnement;
    }

    public int getNbGarage() {
        return nbGarage;
    }

    public void setNbGarage(int nbGarage) {
        this.nbGarage = nbGarage;
    }

    public double getSuperficie() {
        return superficie;
    }

    public void setSuperficie(double superficie) {
        this.superficie = superficie;
    }

    public int getAnneeConstruction() {
        return anneeConstruction;
    }

    public void setAnneeConstruction(int anneeConstruction) {
        this.anneeConstruction = anneeConstruction;
    }
}
