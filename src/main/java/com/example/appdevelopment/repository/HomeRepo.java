package com.example.appdevelopment.repository;
import com.example.appdevelopment.repository.HomeRepo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

// import com.example.appdevelopment.controller.HomeModel;
@Repository
public interface HomeRepo extends JpaRepository<com.example.appdevelopment.model.HomeModel,Integer>{

    
} 