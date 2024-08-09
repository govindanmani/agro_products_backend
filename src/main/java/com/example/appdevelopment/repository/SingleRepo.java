package com.example.appdevelopment.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.appdevelopment.model.Single;
@Repository
public interface SingleRepo extends JpaRepository<Single,Integer> {

    Optional<Single> findByCategoryContaining(String category);
    
}
