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

import com.example.appdevelopment.model.HomeCardModel;
import com.example.appdevelopment.service.HomeCardService;
@CrossOrigin("http://localhost:3000")
@RestController
public class HomeCardController {
    
    @Autowired
    private HomeCardService homeCardService;

    @PostMapping("/homefru")
    public ResponseEntity<?> postMethodName(@RequestBody HomeCardModel homeCardModel) {
       return homeCardService.postMethod(homeCardModel);
    }

    @GetMapping("/homefru")
    public List<HomeCardModel> getMethodName() {
        return homeCardService.getMethod();
    }

    // @GetMapping("/vegetables/{category}")
    // public List<VegetableModel> getName(@PathVariable String category) {
    //     return vegetableService.getByCate(category);
    // }

    @PutMapping("/homefru/{id}")
    public ResponseEntity<?> putMethodName(@PathVariable int id, @RequestBody HomeCardModel homeCardModel) {
        return homeCardService.putMethod(id,homeCardModel);
    }

    @DeleteMapping("/homefru/{id}")
    public ResponseEntity<?> deleteMethod(@PathVariable int id)
    {
        return homeCardService.deleteMethod(id);
    }
    

}
