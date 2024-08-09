package com.example.appdevelopment.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.appdevelopment.model.HomeCardModel;
@Repository
public interface HomeCardRepo extends JpaRepository<HomeCardModel,Integer> {

    
} 
