package com.turkcell.spring.starter.services.abstracts;

import com.turkcell.spring.starter.entities.Product;
import com.turkcell.spring.starter.services.dtos.product.requests.AddProductRequest;
import com.turkcell.spring.starter.services.dtos.product.responses.ProductListResponse;

import java.util.List;

public interface ProductService
{
    void add(AddProductRequest request);
    List<ProductListResponse> getAll();
    List<ProductListResponse> search(String query);
    List<Product> price(double price);
}
