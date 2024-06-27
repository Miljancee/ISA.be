package com.example.demo.controllers;
import com.example.demo.entities.Product;
import com.example.demo.repositories.IProductRepository;
import com.example.demo.repositories.IUserProductsRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("products")
@RequiredArgsConstructor
@CrossOrigin("*")
public class ProductController {

    private final IProductRepository productRepository;
    private final IUserProductsRepository userProductsRepository;


    @GetMapping("get-user-list")
    public List<Product> getList(){
        return productRepository.findAll();

    }


}
