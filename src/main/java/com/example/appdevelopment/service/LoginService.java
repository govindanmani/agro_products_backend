package com.example.appdevelopment.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import com.example.appdevelopment.model.LoginModel;
import com.example.appdevelopment.repository.LoginRepo;

@Service
public class LoginService {
    
    @Autowired
    private LoginRepo loginRepo;

     public ResponseEntity<?> register(@RequestBody LoginModel loginModel) {
        try {
            loginRepo.save(loginModel);
            return new ResponseEntity<>(HttpStatus.CREATED);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    public List<LoginModel> getMethodeList()
    {
        return loginRepo.findAll();
    }

    public ResponseEntity<LoginModel> login(String email, String password) {
        Optional<LoginModel> isExistingUser = loginRepo.findById(email);
        if (isExistingUser.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        LoginModel user = isExistingUser.get();
        if (!password.equals(user.getPassword())) {
            return new ResponseEntity<>(HttpStatus.FORBIDDEN);
        }

        return ResponseEntity.ok(user);
    }

    public ResponseEntity<?> getMethod(String email) {
        Optional<LoginModel> action = loginRepo.findById(email);
        if (action.isPresent()) {
            return new ResponseEntity<>(action.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Action not found", HttpStatus.NOT_FOUND);
        }
    }

    public ResponseEntity<?> putMethodName(String email, LoginModel loginmModel) {
        Optional<LoginModel> existingAction = loginRepo.findById(email);
        if (existingAction.isPresent()) {
            // login.setId(email);
            loginRepo.save(loginmModel);
            return new ResponseEntity<>(HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Action not found", HttpStatus.NOT_FOUND);
        }
    }

    public ResponseEntity<?> deleteItem(String email) {
        Optional<LoginModel> existingAction = loginRepo.findById(email);
        if (existingAction.isPresent()) {
            loginRepo.deleteById(email);
            return new ResponseEntity<>(HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Action not found", HttpStatus.NOT_FOUND);
        }
    }
}
