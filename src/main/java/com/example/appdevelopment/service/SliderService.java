package com.example.appdevelopment.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import com.example.appdevelopment.model.SliderModel;
import com.example.appdevelopment.repository.SliderRepo;

@Service
public class SliderService {
    
@Autowired
   private SliderRepo fruitRepo;

    public ResponseEntity<?> postMethod(@RequestBody SliderModel fruitModel)
    {
        try{
            fruitRepo.save(fruitModel);
            return new  ResponseEntity<>(HttpStatus.CREATED);
        }
        catch(Exception e)
        {
            System.out.print(e.getMessage());
            return new  ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    public List<SliderModel>getMethod()
    {
        return fruitRepo.findAll();
    }

    public ResponseEntity<?> getByName(int id)
    {
        Optional<SliderModel> fru=fruitRepo.findById(id);
        if(fru.isPresent())
        {
            return new ResponseEntity<>(fru.get(),HttpStatus.OK);
        }
        else{
            return new ResponseEntity<>("Action is not found",HttpStatus.NOT_FOUND);

        }
    }
    public ResponseEntity<?> putMethod(int id,SliderModel fruitModel)
    {
        Optional<SliderModel> put=fruitRepo.findById(id);
        if(put.isPresent())
        {
            fruitModel.setId(id);
            fruitRepo.save(fruitModel);
            return new ResponseEntity<>(HttpStatus.OK);
        }
        else{
            return new ResponseEntity<>("Action is not found",HttpStatus.NOT_FOUND);
        }
    }

    public ResponseEntity<?> deleteMethod(int id)
    {
       Optional<SliderModel> existingAction = fruitRepo.findById(id);
       if (existingAction.isPresent()) {
            fruitRepo.deleteById(id);
            return new ResponseEntity<>(HttpStatus.OK);
       } else {
            return new ResponseEntity<>("Action not found", HttpStatus.NOT_FOUND);
       }
    }
}
