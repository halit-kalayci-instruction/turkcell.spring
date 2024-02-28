package com.turkcell.spring.starter.controllers;

import com.turkcell.spring.starter.entities.Product;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/products")
public class ProductsController
{
    // Endpoint yönet
    private List<Product> productList = new ArrayList<>();


    @PostMapping
    public void add(@RequestBody Product product)
    {
    }
    @GetMapping
    public List<Product> get() {
        return productList;
    }
}