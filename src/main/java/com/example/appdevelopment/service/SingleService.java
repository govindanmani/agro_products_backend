package com.example.appdevelopment.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import com.example.appdevelopment.model.Single;
import com.example.appdevelopment.repository.SingleRepo;

@Service
public class SingleService {
    
    @Autowired
    private SingleRepo singleRepo;

    public boolean postMethod(@RequestBody Single single)
    {
        try{
            singleRepo.save(single);
        }
        catch(Exception e)
        {
            return false;
        }
        return true;
    }

    public List<Single> getMethod()
    {
        return singleRepo.findAll();
    }
    public Optional<Single> getMethodName(String category)
    {
        return singleRepo.findByCategoryContaining(category);
    }
}
