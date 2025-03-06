package com.kriNad.backend.model.property;
import jakarta.persistence.*;

@MappedSuperclass
public class Property {

    @Id
    private Long idProperty;

    @Column(columnDefinition = "TEXT")
    private String description;

    private String typeProperty;
    private String categorie;
    private Double price;
    private String address;
    private Long nbRooms;
    private Long nbBathrooms;
    private Long nbParkingSpace;
    private Long nbGarages;
    private Double area;
    private Long ConstructionYear;
    private String city;

    // revoir
    private String status;

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

    public Long getNbRooms() {
        return nbRooms;
    }

    public void setNbRooms(Long nbChambre) {
        this.nbRooms = nbChambre;
    }

    public Long getNbBathrooms() {
        return nbBathrooms;
    }

    public void setNbBathrooms(Long nbSalleBain) {
        this.nbBathrooms = nbSalleBain;
    }

    public Long getNbParkingSpace() {
        return nbParkingSpace;
    }

    public void setNbParkingSpace(Long nbstationnement) {
        this.nbParkingSpace = nbstationnement;
    }

    public Long getNbGarages() {
        return nbGarages;
    }

    public void setNbGarages(Long nbGarage) {
        this.nbGarages = nbGarage;
    }

    public Double getArea() {
        return area;
    }

    public void setArea(Double superficie) {
        this.area = superficie;
    }

    public Long getConstructionYear() {
        return ConstructionYear;
    }

    public void setConstructionYear(Long anneeConstruction) {
        this.ConstructionYear = anneeConstruction;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }
}



