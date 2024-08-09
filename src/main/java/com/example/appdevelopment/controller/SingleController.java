package com.example.appdevelopment.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import com.example.appdevelopment.model.Single;
import com.example.appdevelopment.service.SingleService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;


@CrossOrigin("http://localhost:3000")
@RestController
public class SingleController {
    
    @Autowired
    private SingleService singleService;


    @PostMapping("/single")
    public ResponseEntity<?> postMethodName(@RequestBody Single single) {
        singleService.postMethod(single);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    
    @GetMapping("/single")
    public ResponseEntity<List<Single>> getAllData() {
        List<Single> singles = singleService.getMethod();
        return new ResponseEntity<>(singles, HttpStatus.OK);
    }

    @GetMapping("/single/{category}")
    public ResponseEntity<Optional<Single>> getMethodParticular(@PathVariable String category) {
        Optional<Single> single = singleService.getMethodName(category);
        return new ResponseEntity<>(single, HttpStatus.OK);
    }
    

}
