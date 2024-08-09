package com.example.appdevelopment.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class SliderModel {
    @Id
    private int id;
    private String img;
    private String category;
}
