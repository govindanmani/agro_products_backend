package com.example.appdevelopment.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import com.example.appdevelopment.model.Cart;
import com.example.appdevelopment.repository.CartRepo;

@Service
public class CartService {
    
    @Autowired
    private CartRepo cartRepo;

    public boolean postMethod(@RequestBody Cart cart)
    {
        try{
            cartRepo.save(cart);
        }
        catch(Exception e)
        {
            return false;
        }
        return true;
    }
    public List<Cart> getMethod()
    {
        return cartRepo.findAll();
    }
}
