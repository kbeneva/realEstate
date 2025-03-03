package com.kriNad.backend.model.property;


import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

@Entity
public class ImageProperty {

    @Id
    private Long idImage;
    private String imageLink;


    public Long getIdImage() {
        return idImage;
    }

    public void setIdImage(Long idImage) {
        this.idImage = idImage;
    }

    public String getImageLink() {
        return imageLink;
    }

    public void setImageLink(String imageLink) {
        this.imageLink = imageLink;
    }



    @ManyToOne
    private PropertyRent propertyRent;

    @ManyToOne
    private PropertySale propertySale;
}
