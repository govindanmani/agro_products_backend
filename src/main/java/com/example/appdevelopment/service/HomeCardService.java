package com.example.appdevelopment.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import com.example.appdevelopment.model.HomeCardModel;
import com.example.appdevelopment.repository.HomeCardRepo;

@Service
public class HomeCardService {
    
    @Autowired
    private HomeCardRepo homeCardRepo;

     public ResponseEntity<?> postMethod(@RequestBody HomeCardModel homeCardModel)
    {
        try{
            homeCardRepo.save(homeCardModel);
            return new  ResponseEntity<>(HttpStatus.CREATED);
        }
        catch(Exception e)
        {
            System.out.print(e.getMessage());
            return new  ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    public List<HomeCardModel>getMethod()
    {
        return homeCardRepo.findAll();
    }

    public ResponseEntity<?> getByName(int id)
    {
        Optional<HomeCardModel> veg=homeCardRepo.findById(id);
        if(veg.isPresent())
        {
            return new ResponseEntity<>(veg.get(),HttpStatus.OK);
        }
        else{
            return new ResponseEntity<>("Action is not found",HttpStatus.NOT_FOUND);

        }
    }
    // public List<HomeCardModel> getByCate(String category)
    // {
    //     return homeCardRepo.findByCategory(category);
        
    // }
    public ResponseEntity<?> putMethod( int id,HomeCardModel homeCardModel)
    {
        Optional<HomeCardModel> put=homeCardModel.findById(id);
        if(put.isPresent())
        {
            homeCardModel.setId(id);
            homeCardRepo.save(homeCardModel);
            return new ResponseEntity<>(HttpStatus.OK);
        }
        else{
            return new ResponseEntity<>("Action is not found",HttpStatus.NOT_FOUND);
        }
    }

    public ResponseEntity<?> deleteMethod(int id)
    {
       Optional<HomeCardModel> existingAction = homeCardRepo.findById(id);
       if (existingAction.isPresent()) {
            homeCardRepo.deleteById(id);
            return new ResponseEntity<>(HttpStatus.OK);
       } else {
            return new ResponseEntity<>("Action not found", HttpStatus.NOT_FOUND);
       }
    }
}
