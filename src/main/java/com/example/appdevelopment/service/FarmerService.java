package com.example.appdevelopment.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import com.example.appdevelopment.model.FarmerModel;
import com.example.appdevelopment.model.LoginModel;
import com.example.appdevelopment.repository.FarmerRepo;

@Service
public class FarmerService {
    
    @Autowired
    private FarmerRepo farmerRepo;
     public ResponseEntity<?> postMethod(@RequestBody FarmerModel farmerModel) {
        try {
            farmerRepo.save(farmerModel);
            return new ResponseEntity<>(HttpStatus.CREATED);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
   
    public List<FarmerModel> getMethod(String name)
    {
        return farmerRepo.findByName(name);
    }
    public List<FarmerModel> getMethodName()
    {
        return farmerRepo.findAll();
    }
}
