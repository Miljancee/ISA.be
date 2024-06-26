package com.example.demo.controllers;

import com.example.demo.mapers.UserMapers;
import com.example.demo.models.UserModel;
import com.example.demo.models.UserPageModel;
import com.example.demo.repositories.IUserRepository;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import com.example.demo.entities.User;

import java.util.List;

@RestController
@RequestMapping("user")
@RequiredArgsConstructor
@CrossOrigin("*")
public class UserController {

    private final IUserRepository userRepository;


    @CrossOrigin("*")
    @GetMapping("get-first-name")
    public String getFirstName(){
        return "Miljan";
    }

    @GetMapping("get-user-list")
    public List<UserModel> getUserList(){
        return UserMapers.toModelList(userRepository.findAll());

    }

    @GetMapping("get-user-page-list")
    public UserPageModel getUserPageList(Integer pageNumber, Integer pageSize){
        return UserMapers.toModelPagedList(userRepository.findAll(PageRequest.of(0, 20)));

    }

    @GetMapping("create-user")
    public boolean createUser(String firstName, String lastName){
        return true;
    }

    @GetMapping("create-user-body")
    public ResponseEntity<?> createUserBody(@RequestBody @Valid UserModel userModel, BindingResult result){
        if (result.hasErrors()) {
            return new  ResponseEntity<>("Neuspesno registrovan!", HttpStatus.INTERNAL_SERVER_ERROR);
        }

        var entity = UserMapers.toEntity(userModel);
        userRepository.save(entity);

        return new ResponseEntity<UserModel>(userModel, HttpStatus.CREATED);
    }

}
