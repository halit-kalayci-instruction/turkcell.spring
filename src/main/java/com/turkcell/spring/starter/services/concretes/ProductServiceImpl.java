package com.turkcell.spring.starter.services.concretes;

import com.turkcell.spring.starter.entities.Product;
import com.turkcell.spring.starter.services.abstracts.ProductService;

import java.util.List;

public class ProductServiceImpl implements ProductService
{

    @Override
    public void add(Product product) {
        if(product.getUnitPrice() < 0)
            throw new RuntimeException("Ürün fiyatı 0'dan küçük olamaz.");
    }

    @Override
    public List<Product> getAll() {
        return null;
    }
}
