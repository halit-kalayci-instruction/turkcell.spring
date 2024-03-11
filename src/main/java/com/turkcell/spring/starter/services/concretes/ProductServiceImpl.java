package com.turkcell.spring.starter.services.concretes;

import com.turkcell.spring.starter.core.exception.types.BusinessException;
import com.turkcell.spring.starter.entities.Category;
import com.turkcell.spring.starter.entities.Product;
import com.turkcell.spring.starter.repositories.abstracts.ProductRepository;
import com.turkcell.spring.starter.services.abstracts.ProductService;
import com.turkcell.spring.starter.services.dtos.product.requests.AddProductRequest;
import com.turkcell.spring.starter.services.dtos.product.responses.ProductListResponse;
import lombok.AllArgsConstructor;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class ProductServiceImpl implements ProductService
{
    private final ProductRepository productRepository;
    private final MessageSource messageSource;

    @Override
    public void add(AddProductRequest request) {
        // Aynı ürün isminden 2. ürün eklenemez.
        productWithSameNameShouldNotExists(request.getName());
        // TODO: Check from db
        Category category = new Category();
        category.setId(request.getCategoryId());

        // Mapping -> Manual
        // TODO: Auto Mapping
        Product product = new Product();
        product.setName(request.getName());
        product.setStock(request.getStock());
        product.setUnitPrice(request.getUnitPrice());
        product.setCategory(category);
        productRepository.save(product);
    }

    // 7:00
    @Override
    public List<ProductListResponse> getAll() {
        List<Product> products = productRepository.findAll();
        List<ProductListResponse> response = new ArrayList<>();

        // Beginner Level List Mapping
        for (Product product: products) {
            ProductListResponse dto = new ProductListResponse(
                    product.getId(),
                    product.getName(),
                    product.getCategory().getName(),
                    product.getUnitPrice());
            response.add(dto);
        }
        // Request - Response (Reply) Pattern
        return response;
    }

    @Override
    public List<ProductListResponse> search(String query) {
        return productRepository.searchDto(query);
    }

    @Override
    public List<Product> price(double price) {
        return productRepository.findByUnitPriceGreaterThan(price);
    }

    private void productWithSameNameShouldNotExists(String name)
    {
        Optional<Product> productWithSameName =
                productRepository.findByName(name);
        if(productWithSameName.isPresent())
            throw new BusinessException(messageSource.getMessage("sameProductError",null, LocaleContextHolder.getLocale()));
    }
}
// Docker
