package com.example.appdevelopment.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.appdevelopment.model.LoginModel;
@Repository
public interface LoginRepo extends JpaRepository <LoginModel,String>{

    
}