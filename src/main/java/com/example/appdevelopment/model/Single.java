package com.example.appdevelopment.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class Single {
    @Id
    private int id;
    private String category;
    private String img;
}
