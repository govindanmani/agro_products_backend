package com.example.appdevelopment.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.appdevelopment.model.HomeFruitModel;
import com.example.appdevelopment.service.HomeFruitService;
@CrossOrigin("http://localhost:3000")
@RestController
public class HomeFruitController {
    
    @Autowired
    private HomeFruitService homeFruitService;

    @PostMapping("/homefruit")
    public ResponseEntity<?> postMethodName(@RequestBody HomeFruitModel homeFruitModel) {
       return homeFruitService.postMethod(homeFruitModel);
    }

    @GetMapping("/homefruit")
    public List<HomeFruitModel> getMethodName() {
        return homeFruitService.getMethod();
    }

    // @GetMapping("/vegetables/{category}")
    // public List<VegetableModel> getName(@PathVariable String category) {
    //     return vegetableService.getByCate(category);
    // }

    @PutMapping("/homefruit/{id}")
    public ResponseEntity<?> putMethodName(@PathVariable int id, @RequestBody HomeFruitModel homeFruitModel) {
        return homeFruitService.putMethod(id,homeFruitModel);
    }

    @DeleteMapping("/homefruit/{id}")
    public ResponseEntity<?> deleteMethod(@PathVariable int id)
    {
        return homeFruitService.deleteMethod(id);
    }

}
