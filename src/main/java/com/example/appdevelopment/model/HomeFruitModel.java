package com.example.appdevelopment.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class HomeFruitModel {
    
    @Id
    private int id;
    private String img;
    private String data;
    private String place;
    private String offer;
    private String original;
}
