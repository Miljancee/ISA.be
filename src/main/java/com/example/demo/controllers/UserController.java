package com.example.demo.controllers;

import com.example.demo.models.UserModel;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("user")
public class UserController {

    @GetMapping("get-first-name")
    public String getFirstName(){
        return "Miljan";
    }

    @GetMapping("get-first-name-list")
    public List<String> getFirstNameList(){
        return List.of("Miljan", "Miljana");
    }

    @GetMapping("create-user")
    public boolean createUser(String firstName, String lastName){
        return true;
    }

    @GetMapping("create-user-body")
    public UserModel createUserBody(@RequestBody UserModel userModel){
        return userModel;
    }

}
