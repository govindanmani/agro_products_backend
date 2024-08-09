package com.example.appdevelopment.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import com.example.appdevelopment.model.VegetableModel;
import com.example.appdevelopment.repository.VegetableRepo;

@Service
public class VegetableService {
    
    @Autowired
    private VegetableRepo vegetableRepo;

    public ResponseEntity<?> postMethod(@RequestBody VegetableModel vegetableModel)
    {
        try{
            vegetableRepo.save(vegetableModel);
            return new  ResponseEntity<>(HttpStatus.CREATED);
        }
        catch(Exception e)
        {
            System.out.print(e.getMessage());
            return new  ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    public List<VegetableModel>getMethod()
    {
        return vegetableRepo.findAll();
    }

    public ResponseEntity<?> getByName(int id)
    {
        Optional<VegetableModel> veg=vegetableRepo.findById(id);
        if(veg.isPresent())
        {
            return new ResponseEntity<>(veg.get(),HttpStatus.OK);
        }
        else{
            return new ResponseEntity<>("Action is not found",HttpStatus.NOT_FOUND);

        }
    }
    public List<VegetableModel> getByCate(String category)
    {
        return vegetableRepo.findByCategory(category);
        
    }
    public Optional<VegetableModel> getByCard(int id)
    {
        return vegetableRepo.findById(id);
    }
    public ResponseEntity<?> putMethod( int id,VegetableModel vegetableModel)
    {
        Optional<VegetableModel> put=vegetableRepo.findById(id);
        if(put.isPresent())
        {
            vegetableModel.setId(id);
            vegetableRepo.save(vegetableModel);
            return new ResponseEntity<>(HttpStatus.OK);
        }
        else{
            return new ResponseEntity<>("Action is not found",HttpStatus.NOT_FOUND);
        }
    }

    public ResponseEntity<?> deleteMethod(int id)
    {
       Optional<VegetableModel> existingAction = vegetableRepo.findById(id);
       if (existingAction.isPresent()) {
            vegetableRepo.deleteById(id);
            return new ResponseEntity<>(HttpStatus.OK);
       } else {
            return new ResponseEntity<>("Action not found", HttpStatus.NOT_FOUND);
       }
    }

}
