package com.example.appdevelopment.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.appdevelopment.model.HomeFruitModel;
@Repository
public interface HomeFruitRepo extends JpaRepository<HomeFruitModel,Integer>{

    
} 