package com.example.appdevelopment.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import com.example.appdevelopment.model.HomeModel;
// import com.example.appdevelopment.controller.HomeModel;
import com.example.appdevelopment.repository.HomeRepo;

@Service
public class HomeService {
    
    @Autowired
    private HomeRepo homeRepo;

    public ResponseEntity<?> postMethod(@RequestBody HomeModel homeModel)
    {
        try{
            homeRepo.save(homeModel);
            return new  ResponseEntity<>(HttpStatus.CREATED);
        }
        catch(Exception e)
        {
            System.out.print(e.getMessage());
            return new  ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    public List<HomeModel>getMethod()
    {
        return homeRepo.findAll();
    }

    public ResponseEntity<?> getByName(int id)
    {
        Optional<HomeModel> veg=homeRepo.findById(id);
        if(veg.isPresent())
        {
            return new ResponseEntity<>(veg.get(),HttpStatus.OK);
        }
        else{
            return new ResponseEntity<>("Action is not found",HttpStatus.NOT_FOUND);

        }
    }
    // public List<VegetableModel> getByCate(String category)
    // {
    //     return vegetableRepo.findByCategory(category);
        
    // }
    public ResponseEntity<?> putMethod( int id,HomeModel homeModel)
    {
        Optional<HomeModel> put=homeRepo.findById(id);
        if(put.isPresent())
        {
            homeModel.setId(id);
            homeRepo.save(homeModel);
            return new ResponseEntity<>(HttpStatus.OK);
        }
        else{
            return new ResponseEntity<>("Action is not found",HttpStatus.NOT_FOUND);
        }
    }

    public ResponseEntity<?> deleteMethod(int id)
    {
       Optional<HomeModel> existingAction = homeRepo.findById(id);
       if (existingAction.isPresent()) {
            homeRepo.deleteById(id);
            return new ResponseEntity<>(HttpStatus.OK);
       } else {
            return new ResponseEntity<>("Action not found", HttpStatus.NOT_FOUND);
       }
    }

}
