package com.example.appdevelopment.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class HomeModel {
    
    @Id
    private int id;
    private String img;
    private String data;
    private String path;
}
