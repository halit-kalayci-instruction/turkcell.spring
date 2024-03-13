package com.turkcell.spring.starter.services.concretes;

import com.turkcell.spring.starter.core.exception.types.BusinessException;
import com.turkcell.spring.starter.core.services.abstracts.MessageService;
import com.turkcell.spring.starter.entities.Category;
import com.turkcell.spring.starter.entities.Product;
import com.turkcell.spring.starter.repositories.abstracts.ProductRepository;
import com.turkcell.spring.starter.services.abstracts.ProductService;
import com.turkcell.spring.starter.services.constants.Messages;
import com.turkcell.spring.starter.services.dtos.product.requests.AddProductRequest;
import com.turkcell.spring.starter.services.dtos.product.responses.ProductListResponse;
import com.turkcell.spring.starter.services.mappers.ProductMapper;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ProductServiceImpl implements ProductService
{
    private final ProductRepository productRepository;
    private final MessageService messageService;

    public ProductServiceImpl(ProductRepository productRepository, MessageService messageService) {
        this.productRepository = productRepository;
        this.messageService = messageService;
    }

    @Override
    public void add(AddProductRequest request) {
        productWithSameNameShouldNotExists(request.getName());
        Product product = ProductMapper.INSTANCE.productFromAddRequest(request);
        productRepository.save(product);
    }

    // 7:00
    @Override
    public List<ProductListResponse> getAll() {
       /* List<Product> products = productRepository.findAll();
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
        return response;*/
        return null;
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
            throw new BusinessException(messageService.getMessageWithArgs(Messages.BusinessErrors.SAME_PRODUCT_ERROR, name));
    }
}
// Docker
