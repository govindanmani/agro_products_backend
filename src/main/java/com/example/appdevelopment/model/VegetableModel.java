package com.example.appdevelopment.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;
@Entity
@Data
public class VegetableModel {
    @Id

    private int id;
    private String img;
    private String data;
    private String owner;
    private String place;
    private String offer;
    private String original;
    private String category;
   
}
