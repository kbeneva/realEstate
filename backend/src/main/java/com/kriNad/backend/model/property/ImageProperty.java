package com.kriNad.backend.model.property;

import jakarta.persistence.*;

@MappedSuperclass
public class ImageProperty {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idImage;

    @Column(columnDefinition = "TEXT")
    private String imageLink;


    public void setImageLink(String imageLink) {
        this.imageLink = imageLink;
    }








}
