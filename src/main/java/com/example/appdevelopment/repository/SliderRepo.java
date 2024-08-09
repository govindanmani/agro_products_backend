package com.example.appdevelopment.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.appdevelopment.model.SliderModel;

@Repository
public interface SliderRepo extends JpaRepository<SliderModel,Integer>{

    
}
