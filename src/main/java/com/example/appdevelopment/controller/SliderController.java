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
// import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.example.appdevelopment.model.SliderModel;
import com.example.appdevelopment.service.SliderService;

@CrossOrigin("http://localhost:3000")
@RestController
public class SliderController {
    
    @Autowired
    private SliderService fruitService;

     @PostMapping("/slider")
    public ResponseEntity<?> postMethodName(@RequestBody SliderModel fruitModel) {
       return fruitService.postMethod(fruitModel);
    }

    @GetMapping("/slider")
    public List<SliderModel> getMethodName() {
        return fruitService.getMethod();
    }

    @GetMapping("/slider/{id}")
    public ResponseEntity<?> getName(@PathVariable int id) {
        return fruitService.getByName(id);
    }

    @PutMapping("/slider/{id}")
    public ResponseEntity<?> putMethodName(@PathVariable int id, @RequestBody SliderModel fruitModel) {
        return fruitService.putMethod(id,fruitModel);
    }

    @DeleteMapping("/slider/{id}")
    public ResponseEntity<?> deleteMethod(@PathVariable int id)
    {
        return fruitService.deleteMethod(id);
    }

    
}
