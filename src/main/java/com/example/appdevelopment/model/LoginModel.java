package com.example.appdevelopment.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class LoginModel {
    
    @Id
    private String email;
    private String password;
    private String name;
}
