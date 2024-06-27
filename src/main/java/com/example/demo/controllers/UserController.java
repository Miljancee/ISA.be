package com.example.demo.controllers;

import com.example.demo.mapers.UserMappers;
import com.example.demo.mapers.UserProductsMapper;
import com.example.demo.models.UserModel;
import com.example.demo.models.UserPageModel;
import com.example.demo.models.UserProductsModel;
import com.example.demo.repositories.IUserProductsRepository;
import com.example.demo.repositories.IUserRepository;
import com.example.demo.services.IUserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("user")
@RequiredArgsConstructor
@CrossOrigin("*")
public class UserController {

    private final IUserService userService;

    @GetMapping("get-user-list")
    public List<UserModel> getUserList(){
        return userService.findAll();

   }


    @GetMapping("get-user-products-list")
    public List<UserProductsModel> getUserProductsList(){
        return userService.findUserProductsAll();

    }



    @GetMapping("get-page-list")
    public UserPageModel getPageList(Integer pageNumber, Integer pageSize){
        return userService.findPagedList(PageRequest.of(pageNumber, pageSize));

    }


    @GetMapping("create-user-body")
    public ResponseEntity<?> create(@RequestBody @Valid UserModel userModel, BindingResult result){
        if (result.hasErrors()) {
            return new  ResponseEntity<>("Neuspesno registrovan!", HttpStatus.INTERNAL_SERVER_ERROR);
        }


        return new ResponseEntity<>(userService.create(userModel), HttpStatus.CREATED);
    }

}
