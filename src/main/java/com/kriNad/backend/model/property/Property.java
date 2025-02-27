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
    private Double price;
    private String address;
    private Long nbChambre;
    private Long nbSalleBain;
    private Long nbstationnement;
    private Long nbGarage;
    private Double superficie;
    private Long anneeConstruction;

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

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Long getNbChambre() {
        return nbChambre;
    }

    public void setNbChambre(Long nbChambre) {
        this.nbChambre = nbChambre;
    }

    public Long getNbSalleBain() {
        return nbSalleBain;
    }

    public void setNbSalleBain(Long nbSalleBain) {
        this.nbSalleBain = nbSalleBain;
    }

    public Long getNbstationnement() {
        return nbstationnement;
    }

    public void setNbstationnement(Long nbstationnement) {
        this.nbstationnement = nbstationnement;
    }

    public Long getNbGarage() {
        return nbGarage;
    }

    public void setNbGarage(Long nbGarage) {
        this.nbGarage = nbGarage;
    }

    public Double getSuperficie() {
        return superficie;
    }

    public void setSuperficie(Double superficie) {
        this.superficie = superficie;
    }

    public Long getAnneeConstruction() {
        return anneeConstruction;
    }

    public void setAnneeConstruction(Long anneeConstruction) {
        this.anneeConstruction = anneeConstruction;
    }
}
