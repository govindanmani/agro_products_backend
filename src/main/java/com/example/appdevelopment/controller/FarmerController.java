package com.example.appdevelopment.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.appdevelopment.model.FarmerModel;
import com.example.appdevelopment.model.LoginModel;
import com.example.appdevelopment.service.FarmerService;
@CrossOrigin("http://localhost:3000")
@RestController
public class FarmerController {
    
    @Autowired
    private FarmerService farmerService;

     @PostMapping("/farmer")
    public ResponseEntity<?> postMethodName(@RequestBody FarmerModel farmerModel) {
        return farmerService.postMethod(farmerModel);
    }

     @GetMapping("/farmer/{name}")
    public List<FarmerModel> getMethod(@PathVariable String name) {
        return farmerService.getMethod(name);
    }
     @GetMapping("/farmerdata")
    public List<FarmerModel> getMethod() {
        return farmerService.getMethodName();
    }

}
