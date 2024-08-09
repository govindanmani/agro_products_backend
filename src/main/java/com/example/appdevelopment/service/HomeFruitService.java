package com.example.appdevelopment.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import com.example.appdevelopment.model.HomeFruitModel;
import com.example.appdevelopment.repository.HomeFruitRepo;

@Service
public class HomeFruitService {
    
    @Autowired
    private HomeFruitRepo homeFruitRepo;

     public ResponseEntity<?> postMethod(@RequestBody HomeFruitModel homeFruitModel)
    {
        try{
            homeFruitRepo.save(homeFruitModel);
            return new  ResponseEntity<>(HttpStatus.CREATED);
        }
        catch(Exception e)
        {
            System.out.print(e.getMessage());
            return new  ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    public List<HomeFruitModel>getMethod()
    {
        return homeFruitRepo.findAll();
    }

    public ResponseEntity<?> getByName(int id)
    {
        Optional<HomeFruitModel> veg=homeFruitRepo.findById(id);
        if(veg.isPresent())
        {
            return new ResponseEntity<>(veg.get(),HttpStatus.OK);
        }
        else{
            return new ResponseEntity<>("Action is not found",HttpStatus.NOT_FOUND);

        }
    }
    // public List<HomeFruitModel> getByCate(String category)
    // {
    //     return vegetableRepo.findByCategory(category);
        
    // }
    public ResponseEntity<?> putMethod( int id,HomeFruitModel homeFruitModel)
    {
        Optional<HomeFruitModel> put=homeFruitRepo.findById(id);
        if(put.isPresent())
        {
            homeFruitModel.setId(id);
            homeFruitRepo.save(homeFruitModel);
            return new ResponseEntity<>(HttpStatus.OK);
        }
        else{
            return new ResponseEntity<>("Action is not found",HttpStatus.NOT_FOUND);
        }
    }

    public ResponseEntity<?> deleteMethod(int id)
    {
       Optional<HomeFruitModel> existingAction = homeFruitRepo.findById(id);
       if (existingAction.isPresent()) {
            homeFruitRepo.deleteById(id);
            return new ResponseEntity<>(HttpStatus.OK);
       } else {
            return new ResponseEntity<>("Action not found", HttpStatus.NOT_FOUND);
       }
    }



}
