package com.turkcell.spring.starter.controllers;

import com.turkcell.spring.starter.entities.Product;
import com.turkcell.spring.starter.services.abstracts.ProductService;
import com.turkcell.spring.starter.services.concretes.ProductServiceImpl;
import com.turkcell.spring.starter.services.dtos.product.ProductForAddDto;
import com.turkcell.spring.starter.services.dtos.product.ProductForListingDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/products")
public class ProductsController
{
    // Dependency Injection
    // @Autowired
    private ProductService productService;

    public ProductsController(ProductService productService) {
        this.productService = productService;
    }

    // DTO => Data Transfer Object
    @PostMapping
    public void add(@RequestBody ProductForAddDto productForAddDto)
    {
        productService.add(productForAddDto);
    }
    @GetMapping
    public List<ProductForListingDto> get() {
        return productService.getAll();
    }
}