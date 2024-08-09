package com.example.appdevelopment.model;

import java.util.Optional;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class HomeCardModel {
    
    @Id
    private int id;
    private String img;
    private String data;
    private String owner;
    private String place;
    private String path;
    public Optional<HomeCardModel> findById(int id2) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'findById'");
    }
}
