package com.turkcell.spring.starter.controllers;

import com.turkcell.spring.starter.services.abstracts.ProductService;
import com.turkcell.spring.starter.services.dtos.product.requests.AddProductRequest;
import com.turkcell.spring.starter.services.dtos.product.responses.ProductListResponse;
import org.springframework.web.bind.annotation.*;

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
    public void add(@RequestBody AddProductRequest request)
    {
        productService.add(request);
    }
    @GetMapping
    public List<ProductListResponse> get() {
        return productService.getAll();
    }
}