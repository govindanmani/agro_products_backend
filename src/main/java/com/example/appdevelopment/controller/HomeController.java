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

import com.example.appdevelopment.model.HomeModel;
import com.example.appdevelopment.service.HomeService;
@CrossOrigin("http://localhost:3000")
@RestController
public class HomeController {
    
    @Autowired
    private HomeService homeService;
    
    @PostMapping("/topproduct")
    public ResponseEntity<?> postMethodName(@RequestBody HomeModel homeModel) {
       return homeService.postMethod(homeModel);
    }

    @GetMapping("/topproduct")
    public List<HomeModel> getMethodName() {
        return homeService.getMethod();
    }

    // @GetMapping("/vegetables/{category}")
    // public List<VegetableModel> getName(@PathVariable String category) {
    //     return vegetableService.getByCate(category);
    // }

    @PutMapping("/topproduct/{id}")
    public ResponseEntity<?> putMethodName(@PathVariable int id, @RequestBody HomeModel homeModel) {
        return homeService.putMethod(id,homeModel);
    }

    @DeleteMapping("/topproduct/{id}")
    public ResponseEntity<?> deleteMethod(@PathVariable int id)
    {
        return homeService.deleteMethod(id);
    }

    public void setId(int id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'setId'");
    }
}
