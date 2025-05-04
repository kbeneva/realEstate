package com.kriNad.backend.DTO;

import java.util.List;

public class PropertyRentRequest {
    private Long customerId;
    private String description;
    private String categorie;
    private Double price;
    private String address;
    private Long nbRooms;
    private Long nbBathrooms;
    private Long nbParkingSpace;
    private Long nbGarages;
    private Double area;
    private Long constructionYear;
    private String city;
    private Long maxOccupants;
    private List<String> images;

    public Long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Long customerId) {
        this.customerId = customerId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
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

    public void setNbRooms(Long nbRooms) {
        this.nbRooms = nbRooms;
    }

    public Long getNbBathrooms() {
        return nbBathrooms;
    }

    public void setNbBathrooms(Long nbBathrooms) {
        this.nbBathrooms = nbBathrooms;
    }

    public Long getNbParkingSpace() {
        return nbParkingSpace;
    }

    public void setNbParkingSpace(Long nbParkingSpace) {
        this.nbParkingSpace = nbParkingSpace;
    }

    public Long getNbGarages() {
        return nbGarages;
    }

    public void setNbGarages(Long nbGarages) {
        this.nbGarages = nbGarages;
    }

    public Double getArea() {
        return area;
    }

    public void setArea(Double area) {
        this.area = area;
    }

    public Long getConstructionYear() {
        return constructionYear;
    }

    public void setConstructionYear(Long constructionYear) {
        this.constructionYear = constructionYear;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public Long getMaxOccupants() {
        return maxOccupants;
    }

    public void setMaxOccupants(Long maxOccupants) {
        this.maxOccupants = maxOccupants;
    }

    public List<String> getImages() {
        return images;
    }

    public void setImages(List<String> images) {
        this.images = images;
    }
}
