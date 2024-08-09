package com.example.appdevelopment.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.appdevelopment.model.SliderModel;
import com.example.appdevelopment.model.VegetableModel;

public interface VegetableRepo extends JpaRepository<VegetableModel,Integer> {

     List<VegetableModel> findByCategory(String category);
} 
