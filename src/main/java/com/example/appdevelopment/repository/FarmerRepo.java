package com.example.appdevelopment.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.appdevelopment.model.FarmerModel;
@Repository
public interface FarmerRepo extends JpaRepository<FarmerModel,Integer> {
    List<FarmerModel> findByName(String name);
} 
