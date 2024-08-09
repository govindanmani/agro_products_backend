package com.example.appdevelopment.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.appdevelopment.model.LoginModel;
import com.example.appdevelopment.service.LoginService;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
@CrossOrigin("http://localhost:3000")
public class LoginController {
    
    @Autowired
    private LoginService loginService;

    @PostMapping("/register")
    public ResponseEntity<?> postMethodName(@RequestBody LoginModel loginModel) {
        return loginService.register(loginModel);
    }
    @GetMapping("/register1")
    public List<LoginModel> getMethodName() {
        return loginService.getMethodeList();
    }
    
    
    @PostMapping("/login")
    public ResponseEntity<?> getMethodName(@RequestBody LoginModel loginModel) {
        return loginService.login(loginModel.getEmail(), loginModel.getPassword());
    }

    
    @GetMapping("/login/{email}")
    public ResponseEntity<?> getMethod(@PathVariable String email) {
        return loginService.getMethod(email);
    }

    @PutMapping("/login/{email}")
    public ResponseEntity<?> putMethodName(@PathVariable String email, @RequestBody LoginModel loginModel) {
        return loginService.putMethodName(email, loginModel);
    }

    @DeleteMapping("/login/{id}")
    public ResponseEntity<?> deleteItem(@PathVariable String email) {
        return loginService.deleteItem(email);
    }
}
