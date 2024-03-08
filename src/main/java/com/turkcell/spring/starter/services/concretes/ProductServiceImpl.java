package com.turkcell.spring.starter.services.concretes;

import com.turkcell.spring.starter.entities.Category;
import com.turkcell.spring.starter.entities.Product;
import com.turkcell.spring.starter.repositories.abstracts.ProductRepository;
import com.turkcell.spring.starter.services.abstracts.ProductService;
import com.turkcell.spring.starter.services.dtos.product.ProductForAddDto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService
{
    private ProductRepository productRepository;

    public ProductServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public void add(ProductForAddDto productForAddDto) {
        if(productForAddDto.getUnitPrice() < 0)
            throw new RuntimeException("Ürün fiyatı 0'dan küçük olamaz.");

        // TODO: Check from db
        Category category = new Category();
        category.setId(productForAddDto.getCategoryId());

        // Mapping -> Manual
        // TODO: Auto Mapping
        Product product = new Product();
        product.setName(productForAddDto.getName());
        product.setStock(productForAddDto.getStock());
        product.setUnitPrice(productForAddDto.getUnitPrice());
        product.setCategory(category);
        productRepository.save(product);
    }

    @Override
    public List<Product> getAll() {
        return productRepository.findAll();
    }
}
