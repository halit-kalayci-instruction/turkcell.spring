package com.turkcell.spring.starter.services.abstracts;

import com.turkcell.spring.starter.entities.Product;
import com.turkcell.spring.starter.services.dtos.product.ProductForAddDto;

import java.util.List;

public interface ProductService
{
    void add(ProductForAddDto productForAddDto);
    List<Product> getAll();
}
