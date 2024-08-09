package com.example.appdevelopment.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import com.example.appdevelopment.model.Cart;
import com.example.appdevelopment.service.CartService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


@CrossOrigin("http://localhost:3000")
@RestController
public class CartController {
    
    @Autowired
    private CartService cartService;

    @PostMapping("/card")
    public ResponseEntity<?> postMethodName(@RequestBody Cart cart) {
       cartService.postMethod(cart);
       return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping("/card")
    public List<Cart> getMethod() {
        return cartService.getMethod();
    }
    
    

}
