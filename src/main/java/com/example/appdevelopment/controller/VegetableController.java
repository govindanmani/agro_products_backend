package com.example.appdevelopment.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
// import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.example.appdevelopment.model.VegetableModel;
import com.example.appdevelopment.service.VegetableService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PutMapping;



@CrossOrigin("http://localhost:3000")
@RestController
public class VegetableController {
    
    @Autowired
    private VegetableService vegetableService;

    @PostMapping("/vegetables")
    public ResponseEntity<?> postMethodName(@RequestBody VegetableModel vegetableModel) {
       return vegetableService.postMethod(vegetableModel);
    }

    @GetMapping("/vegetables")
    public List<VegetableModel> getMethodName() {
        return vegetableService.getMethod();
    }

    @GetMapping("/vegetables/{category}")
    public List<VegetableModel> getName(@PathVariable String category) {
        return vegetableService.getByCate(category);
    }
    
    @GetMapping("/{id}")
    public  Optional<VegetableModel> getName(@PathVariable int id) {
        return vegetableService.getByCard(id);
    }
   

    @PutMapping("/vegetables/{id}")
    public ResponseEntity<?> putMethodName(@PathVariable int id, @RequestBody VegetableModel vegetableModel) {
        return vegetableService.putMethod(id,vegetableModel);
    }

    @DeleteMapping("/vegetables/{id}")
    public ResponseEntity<?> deleteMethod(@PathVariable int id)
    {
        return vegetableService.deleteMethod(id);
    }
    
    
    

}

